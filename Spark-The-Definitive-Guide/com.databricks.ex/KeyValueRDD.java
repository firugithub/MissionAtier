import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import scala.Tuple2;

public class KeyValueRDD {

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();

		String arr[] = "Spark The Definitive Guide : Big Data Processing Made Simple".split(" ");

		JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext());
		JavaRDD<String> stringRDD = sparkContext.parallelize(Arrays.asList(arr),2);
		System.out.println(stringRDD.collect());
		JavaPairRDD<String, Integer> pairRdd = stringRDD.mapToPair(i -> new Tuple2<String, Integer>(i.toLowerCase(), 1));
		System.out.println(pairRdd.collect());
		System.out.println(pairRdd.keyBy(x -> x._1.toString()).collect());
		//JavaRDD<Row> rowRDD = sparkContext.parallelize(stringAsList).map(new Function<SomeRandomObjects1, Row>() {
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public Row call(SomeRandomObjects1 arg0) throws Exception {
//				return getRow(arg0);
//			}
//
//			private Row getRow(SomeRandomObjects1 s) {
//				return RowFactory.create(s.id, s.name, s.graduate_program, s.spark_status);
//			}
//		});
//		// Creates schema
//		StructType schema = DataTypes.createStructType(new StructField[] {
//				DataTypes.createStructField("id", DataTypes.IntegerType, false),
//				DataTypes.createStructField("name", DataTypes.StringType, false),
//				DataTypes.createStructField("graduate_program", DataTypes.IntegerType, false),
//				DataTypes.createStructField("spark_status", DataTypes.createArrayType(DataTypes.IntegerType), false) });
//		Dataset<Row> person = spark.sqlContext().createDataFrame(rowRDD, schema).toDF();
//		person.show();
		sparkContext.close();
		spark.close();
	}

}
