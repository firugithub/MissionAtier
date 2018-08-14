import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

public class WorkingWithStrings {
	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		Dataset<Row> rows = spark.read().format("csv").option("header", "true").option("inferSchema", "true").load(
				"/Users/srawat1/Documents/workspaces-learn/Spark-The-Definitive-Guide/data/retail-data/by-day/2010-12-01.csv");
		rows.printSchema();
		rows.createOrReplaceTempView("dfTable");
		rows.select(functions.lower(rows.col("Description")).as("NUOO")).show(5);
	}
}
