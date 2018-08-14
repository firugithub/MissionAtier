import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.StructType;

public class WorkingWithStructType {
	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		Dataset<Row> rows = spark.read().format("csv").option("header", "true").option("inferSchema", "true").load(
				"/Users/srawat1/Documents/workspaces-learn/Spark-The-Definitive-Guide/data/retail-data/by-day/2010-12-01.csv");
		rows.printSchema();
		rows.createOrReplaceTempView("dfTable");
		Dataset<Row> complexdf = rows.select(functions.struct("Description", "InvoiceNo").as("complex"));
		complexdf.createOrReplaceTempView("complexDF");
		complexdf.select("complex.Description").show();
		spark.sql("select * from complexdf ").show();
	}
}
