package com.reservation.bus.analytics;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function3;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.State;
import org.apache.spark.streaming.StateSpec;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaMapWithStateDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservation.bus.event.Event;
import com.reservation.bus.event.UserActivityEvent;
import com.reservation.bus.util.Constants;
import com.reservation.bus.util.Helper;

import scala.Tuple2;

public class CustomerActivityAnalysis {
	static SparkSession spark;

	public static void readFromKafkaTopic() throws InterruptedException {
		spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");
		JavaStreamingContext streamingContext = new JavaStreamingContext(
				JavaSparkContext.fromSparkContext(spark.sparkContext()), new Duration(1000));

		String checkpointPath = File.separator + "tmp" + File.separator + "CAA" + File.separator + "checkpoints";
		File checkpointDir = new File(checkpointPath);
		checkpointDir.mkdir();
		checkpointDir.deleteOnExit();
		streamingContext.checkpoint(checkpointPath);

		Map<String, Object> kafkaParams = new HashMap<>();
		kafkaParams.put("bootstrap.servers", "localhost:9092");
		kafkaParams.put("key.deserializer", StringDeserializer.class);
		kafkaParams.put("value.deserializer", StringDeserializer.class);
		kafkaParams.put("group.id", "use_a_separate_group_id_for_each_stream");
		kafkaParams.put("auto.offset.reset", "latest");
		kafkaParams.put("enable.auto.commit", false);
		Collection<String> topics = Arrays.asList("user_activity");

		final JavaInputDStream<ConsumerRecord<String, String>> stream = KafkaUtils.createDirectStream(streamingContext,
				LocationStrategies.PreferConsistent(),
				ConsumerStrategies.<String, String> Subscribe(topics, kafkaParams));

		JavaDStream<String> lines = stream.map(new Function<ConsumerRecord<String, String>, String>() {
			@Override
			public String call(ConsumerRecord<String, String> kafkaRecord) throws Exception {
				return kafkaRecord.value();
			}
		});
		JavaDStream<UserActivityEvent> userActivity = lines.map(new Function<String, UserActivityEvent>() {

			@Override
			public UserActivityEvent call(String userActivityEvent) throws Exception {
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode node = objectMapper.readTree(userActivityEvent);
				String eventType = node.get("eventType").asText();
				Event event;
				switch (eventType) {
				case "ENTER_TRIP_DETAIL":
					event = Event.ENTER_TRIP_DETAIL;
					break;
				case "CLICK_TO_PAY_TRIP":
					event = Event.CLICK_TO_PAY_TRIP;
					break;
				default:
					event = Event.SUBMIT_PAYMENT;
					break;
				}
				return new UserActivityEvent(Helper.convertStringToDate(node.get("activityDate").asText(),
						Constants.DATE_FORMAT_WITH_TIMEZONE), node.get("userId").asText(), event);
			}
		});
		JavaPairDStream<String, UserActivityEvent> streamOfPairs = userActivity
				.mapToPair(si -> new Tuple2<>(si.getUserId(), si));
		userActivity.print();
		Function3<String, Optional<UserActivityEvent>, State<List<String>>, List<String>> mappingFunction = (category,
				item, state) -> {
			if (state.isTimingOut()) {
				System.out.println("Payment Not Received for");
				System.out.println(state.get());
				return state.getOption().get();
			}
			List<String> list = state.exists() ? state.get() : new ArrayList<>();
			if (item.get().getEventType().equals(Event.CLICK_TO_PAY_TRIP)) {
				list.add(category);
				if (list.size() > 0) {
					state.update(list);
				}
			} else if (item.get().getEventType().equals(Event.SUBMIT_PAYMENT)) {
				if (list.contains(category)) {
					list.remove(category);
					state.update(list);
				}
			}

			return state.get();
		};
		JavaMapWithStateDStream<String, UserActivityEvent, List<String>, List<String>> streamOfCategoryCounts = streamOfPairs
				.mapWithState(StateSpec.function(mappingFunction));

		streamOfCategoryCounts.foreachRDD(rdd -> {
			System.out.println(rdd);
			System.out.println("Batch size: " + rdd.count());
			rdd.foreach(e -> System.out.println(e));
		});
		streamingContext.start();
		streamingContext.awaitTermination();
	}

	public static void main(String args[]) throws InterruptedException {
		readFromKafkaTopic();
	}
}