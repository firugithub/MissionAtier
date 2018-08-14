import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Starter {
	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		long num = spark.range(1000).count();
		spark.range(1000).toDF("number").printSchema();
		Dataset<Row> myrange = spark.range(1000).toDF("number");
		Dataset<Row> divisBy2 = myrange.where("number % 2 = 0");
		System.out.println(divisBy2.count());
	}
}