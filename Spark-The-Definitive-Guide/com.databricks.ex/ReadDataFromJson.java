import java.util.Arrays;

import org.apache.spark.sql.SparkSession;

public class ReadDataFromJson {
	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		spark.read().format("json")
				.load("/Users/srawat1/Documents/workspaces-learn/Spark-The-Definitive-Guide/data/flight-data/json/2015-summary.json")
				.printSchema();
		String[] cols = spark.read().format("json")
				.load("/Users/srawat1/Documents/workspaces-learn/Spark-The-Definitive-Guide/data/flight-data/json/2015-summary.json")
				.columns();
		Arrays.stream(cols).forEach(num -> System.out.println(num));
	}
}
