package com.reservation.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SessionBuilder {
	static SparkSession spark;

	public static void buildSparkSession() {
		spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
	}

	public static Dataset<Row> readRecommendationData() {
		String[] cols = spark.read().format("json").load("eventData/recommended_itinerary.json").columns();
		Dataset<Row> recommendationData = spark.read().format("json").load("eventData/recommended_itinerary.json");
		Arrays.stream(cols).forEach(num -> System.out.println(num));
		return recommendationData;
	}

	public static Dataset<Row> readRequiredTripData() {
		String[] cols = spark.read().format("json").load("eventData/trip_request.json").columns();
		Dataset<Row> requiredTripData = spark.read().format("json").load("eventData/trip_request.json");
		Arrays.stream(cols).forEach(num -> System.out.println(num));
		return requiredTripData;
	}

	public static void main(String args[]) {
		buildSparkSession();
		Dataset<Row> df1 = readRecommendationData();
		Dataset<Row> df2 = readRequiredTripData();
		df1.createOrReplaceTempView("recommendation");
		df2.createOrReplaceTempView("tripRequest");

		Dataset<Row> tripChoices = df1.join(df2, df1.col("route.origin").equalTo(df2.col("origin")))
				.filter(df1.col("route.destination").equalTo(df2.col("destination")))
				.filter(df1.col("departureDate").equalTo(df2.col("dateOfJourney"))).selectExpr("id", "origin",
						"destination", "fare", "departureDate", "departureTime", "arrivalDate", "arrivalTime");
		List<Row> list = tripChoices.collectAsList();
		System.out.println("id, origin,destination, fare, departureDate, departureTime, arrivalDate, arrivalTime");
		for (Row eachRecommendation : list) {
			System.out.println(eachRecommendation.toString());
		}
	}
}