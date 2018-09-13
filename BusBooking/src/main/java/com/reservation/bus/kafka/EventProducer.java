package com.reservation.bus.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.reservation.bus.event.UserActivityEvent;

/*
 * Kafka producer to write the user activity events to kafka topics.
 */
public class EventProducer {
	KafkaProducer<String, String> producer;

	public void createProducer() {

		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		producer = new KafkaProducer<String, String>(props);

	}

	public void produceToUserActivityTopic(UserActivityEvent eventObj) {
		String key = eventObj.getUserId();
		String value = KafkaEventValueGenerator.getUserActivityEventValue(eventObj);
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("user_activity", key, value);
		producer.send(record);
		System.out.printf("key = %s, value = %s\n", key, value);
	}

	public void closeProducer() {
		producer.close();
	}
}
