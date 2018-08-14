import java.util.Arrays;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

public class SparkLiteralAndSelectExpr {
	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		Dataset<Row> rows = spark.read().format("json").load(
				"/Users/srawat1/Documents/workspaces-learn/Spark-The-Definitive-Guide/data/flight-data/json/2015-summary.json");
	rows.printSchema();
		rows.createOrReplaceTempView("flight2015");
		rows.select("DEST_COUNTRY_NAME").show(4);
		rows.selectExpr("*", "1 as One").limit(2).show();
		rows.selectExpr("DEST_COUNTRY_NAME","DEST_COUNTRY_NAME as dest").limit(2).show();
		rows.selectExpr(functions.avg("count").toString(),functions.countDistinct(("DEST_COUNTRY_NAME")).toString()).show();
		//functions.lit(1).as("One")
		
		rows.where(rows.col("count").lt(2)).where(rows.col("ORIGIN_COUNTRY_NAME").notEqual("Croatia")).limit(2).show();
		//Adding a cloumn in dataframe
		
		rows.withColumn("One",functions.lit(1)).show(2);
		
		System.out.println(rows.rdd().getNumPartitions());
	}
}
