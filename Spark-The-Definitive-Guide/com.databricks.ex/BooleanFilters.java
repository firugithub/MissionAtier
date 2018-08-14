import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class BooleanFilters {
	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		Dataset<Row> rows = spark.read().format("csv").option("header", "true").option("inferSchema", "true").load(
				"/Users/srawat1/Documents/workspaces-learn/Spark-The-Definitive-Guide/data/retail-data/by-day/2010-12-01.csv");
		rows.printSchema();
		rows.createOrReplaceTempView("dfTable");
		rows.where(rows.col("StockCode").isin("DOT")).filter("UnitPrice>600")
				.filter(rows.col("Description").like("%POSTAGE%")).show();
		
		rows.where(rows.col("StockCode").isin("DOT"))
		.filter("UnitPrice>600 or Description like '%POSTAGE%'").show();

	}
}
