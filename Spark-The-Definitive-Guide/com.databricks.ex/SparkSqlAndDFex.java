import static org.apache.spark.sql.functions.desc;

import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkSqlAndDFex {

	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		Dataset<Row> flightData2015 = spark.read().option("inferSchema", "true").option("header", "true").csv(
				"/Users/srawat1/Documents/workspaces-learn/Spark-The-Definitive-Guide/data/flight-data/csv/2015-summary.csv");
		flightData2015.createOrReplaceTempView("flight_data_2015");
		// List<Row> details = flightData2015.takeAsList(3);
		// System.out.println(details.toString());
		// spark.conf().set("spark.sql.shuffle.partitions", "5");
		// List<Row> sortedDetails = flightData2015.sort("count").takeAsList(2);
		// System.out.println(sortedDetails.toString());
		// List<Row> details2 = spark.sql("SELECT max(count) from
		// flight_data_2015").takeAsList(1);
		// System.out.println(details2.toString());
		//
		// sql way
		Dataset<Row> sql = spark.sql(
				"SELECT DEST_COUNTRY_NAME, sum(count) as destination_total FROM flight_data_2015 GROUP BY DEST_COUNTRY_NAME ORDER BY sum(count) DESC LIMIT 5");
		spark.conf().set("spark.sql.shuffle.partitions", "5");
		sql.explain();
		List<Row> details3 = sql.collectAsList();
		System.out.println(details3.toString());
		// dataframe way
		flightData2015.groupBy("DEST_COUNTRY_NAME").sum("count").withColumnRenamed("sum(count)", "destination_total")
				.sort(desc("destination_total")).limit(5).show();
		
		System.out.println("end");
	}

}
