import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

public class WorkingWithNumbers {
	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		Dataset<Row> rows = spark.read().format("csv").option("header", "true").option("inferSchema", "true").load(
				"/Users/srawat1/Documents/workspaces-learn/Spark-The-Definitive-Guide/data/retail-data/by-day/2010-12-01.csv");
		rows.printSchema();
		rows.createOrReplaceTempView("dfTable");
		Column col = functions.pow(rows.col("Quantity").multiply(rows.col("UnitPrice")), 2).plus(5);
		rows.select(rows.col("CustomerId"), col.alias("realQuantity")).show(2);
		rows.selectExpr("CustomerId", "(POWER((Quantity * UnitPrice), 2.0) + 5) as realQuantity").show(2);
	}
}
