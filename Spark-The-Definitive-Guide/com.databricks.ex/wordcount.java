import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.SparkSession;

public class wordcount {

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		 SparkContext sc = spark.sparkContext();
		 RDD<String> input = sc.textFile("/Users/srawat1/Documents/oozie-try/input.txt",1);
		 JavaRDD<String> words = input.flatMap(f, evidence$4)
	}

}
//val baseRDD = sc.textFile("/Sample/SampleBigFile.txt")
//val fmap = baseRDD.flatMap(line => line.split(" "))
//val map1 = fmap.map(word => (word, 1))
//val count = map1.reduceByKey((sum, index) => sum+index)
//count.collect
//
//http://localhost:4040
//pyspark
//
//count = sc.textFile("/Sample/SampleBigFile.txt").flatMap(lambda line : line.split(" ")).map(lambda word : (word, 1)).reduceByKey(lambda sum, index : sum+index)
//
//count.collect()
