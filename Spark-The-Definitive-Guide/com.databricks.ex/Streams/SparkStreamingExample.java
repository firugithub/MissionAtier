package Streams;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.types.StructType;

public class SparkStreamingExample {

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		Dataset<Row> staticStr = spark.read()
				.json("/Users/srawat1/Documents/ebooks/MissionATier/Spark-The-Definitive-Guide/data/activity-data");
		StructType schema = staticStr.schema();
		staticStr.printSchema();
		staticStr.show(4);
		Dataset<Row> streamingDataSet = spark.readStream().schema(schema).option("maxFilesPerTrigger", 1)
				.json("/Users/srawat1/Documents/ebooks/MissionATier/Spark-The-Definitive-Guide/data/activity-data");

		Dataset<Row> count = streamingDataSet.groupBy("gt").count();
		spark.conf().set("spark.sql.shuffle.partitions", 5);
		StreamingQuery streamingQuery = count.writeStream().queryName("activity_counts").format("memory")
				.outputMode("complete").start();
//		try {
//			streamingQuery.awaitTermination();
//		} catch (StreamingQueryException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for (int i = 0; i < 5l; i++) {
			spark.sql("SELECT * FROM activity_counts").show();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
