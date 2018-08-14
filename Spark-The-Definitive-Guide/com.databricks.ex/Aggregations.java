import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

public class Aggregations {
	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		Dataset<Row> rows = spark.read().format("csv").option("header", "true").option("inferSchema", "true")
				.load("/Users/srawat1/Documents/workspaces-learn/Spark-The-Definitive-Guide/data/retail-data/all/*.csv")
				.coalesce(5);
		rows.cache();
		rows.printSchema();
		rows.createOrReplaceTempView("dfTable");
		rows.select(functions.count("StockCode")).show();
		rows.select(functions.countDistinct("StockCode")).show();
		rows.select(functions.approx_count_distinct("StockCode", 0.1)).show();
		rows.select(functions.first("StockCode"), functions.last("StockCode")).show();
		rows.select(functions.min("Quantity"), functions.max("Quantity")).show();
		rows.select(functions.sum("Quantity")).show();
		rows.select(functions.sumDistinct("Quantity")).show();
		rows.select(functions.count("Quantity").alias("total_transactions"),
				functions.sum("Quantity").alias("total_purchases"), functions.avg("Quantity").alias("avg_purchases"),
				functions.expr("mean(Quantity)").alias("mean_purchases"))
				.selectExpr("total_purchases/total_transactions", "avg_purchases", "mean_purchases").show();

		// Aggregating to complex types
		rows.agg(functions.collect_set("Country"), functions.collect_list("Country")).show();
	}
}
