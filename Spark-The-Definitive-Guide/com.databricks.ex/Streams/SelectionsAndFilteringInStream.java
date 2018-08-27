package Streams;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.types.StructType;

public class SelectionsAndFilteringInStream {

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		Dataset<Row> staticStr = spark.read()
				.json("/Users/srawat1/Documents/ebooks/MissionATier/Spark-The-Definitive-Guide/data/activity-data");
		StructType schema = staticStr.schema();
		staticStr.printSchema();
		staticStr.show(4);
		Dataset<Row> streamingDataSet = spark.readStream().schema(schema).option("maxFilesPerTrigger", 1)
				.json("/Users/srawat1/Documents/ebooks/MissionATier/Spark-The-Definitive-Guide/data/activity-data");

		spark.conf().set("spark.sql.shuffle.partitions", 5);
		StreamingQuery simpleTransform = streamingDataSet.withColumn("stairs", functions.expr("gt like '%stairs%'")).where("stairs").where("gt is not null").select("gt", "model", "arrival_time", "creation_time").writeStream().queryName("simple_transform").format("memory").outputMode("append").start();
		for (int i = 0; i < 5l; i++) {
			spark.sql("SELECT * FROM simple_transform").show();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
//