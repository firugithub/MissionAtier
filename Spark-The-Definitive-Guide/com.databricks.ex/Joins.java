import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

public class Joins {
	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		List<SomeRandomObjects1> stringAsList = new ArrayList<>();
		stringAsList.add(new SomeRandomObjects1(0, "Bill Chambers", 0, new int[] { 100 }));
		stringAsList.add(new SomeRandomObjects1(1, "Matei Zaharia", 1, new int[] { 500, 250, 100 }));
		stringAsList.add(new SomeRandomObjects1(2, "Michael Armbrust", 1, new int[] { 250, 100 }));

		JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext());

		JavaRDD<Row> rowRDD = sparkContext.parallelize(stringAsList).map(new Function<SomeRandomObjects1, Row>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Row call(SomeRandomObjects1 arg0) throws Exception {
				return getRow(arg0);
			}

			private Row getRow(SomeRandomObjects1 s) {
				return RowFactory.create(s.id, s.name, s.graduate_program, s.spark_status);
			}
		});
System.out.println(rowRDD.first());
		// Creates schema
		StructType schema = DataTypes.createStructType(new StructField[] {
				DataTypes.createStructField("id", DataTypes.IntegerType, false),
				DataTypes.createStructField("name", DataTypes.StringType, false),
				DataTypes.createStructField("graduate_program", DataTypes.IntegerType, false),
				DataTypes.createStructField("spark_status", DataTypes.createArrayType(DataTypes.IntegerType), false) });
		Dataset<Row> person = spark.sqlContext().createDataFrame(rowRDD, schema).toDF();
		person.show();

		List<SomeRandomObjects2> stringAsList2 = new ArrayList<>();
		stringAsList2.add(new SomeRandomObjects2(0, "Masters", "School of Information", "UC Berkeley"));
		stringAsList2.add(new SomeRandomObjects2(2, "Masters", "EECS", "UC Berkeley"));
		stringAsList2.add(new SomeRandomObjects2(1, "Ph.D.", "EECS", "UC Berkeley"));
		JavaRDD<Row> rowRDD2 = sparkContext.parallelize(stringAsList2).map(new Function<SomeRandomObjects2, Row>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Row call(SomeRandomObjects2 arg0) throws Exception {
				return getRow(arg0);
			}

			private Row getRow(SomeRandomObjects2 s) {
				return RowFactory.create(s.id, s.degree, s.department, s.school);
			}
		});

		// Creates schema
		StructType schema2 = DataTypes
				.createStructType(new StructField[] { DataTypes.createStructField("id", DataTypes.IntegerType, false),
						DataTypes.createStructField("degree", DataTypes.StringType, false),
						DataTypes.createStructField("department", DataTypes.StringType, false),
						DataTypes.createStructField("school", DataTypes.StringType, false) });

		Dataset<Row> graduateProgram = spark.sqlContext().createDataFrame(rowRDD2, schema2).toDF();
		graduateProgram.show();

		List<SomeRandomObjects3> stringAsList3 = new ArrayList<>();
		stringAsList3.add(new SomeRandomObjects3(500, "Vice President"));
		stringAsList3.add(new SomeRandomObjects3(250, "PMC Member"));
		stringAsList3.add(new SomeRandomObjects3(100, "Contributor"));
		JavaRDD<Row> rowRDD3 = sparkContext.parallelize(stringAsList3).map(new Function<SomeRandomObjects3, Row>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Row call(SomeRandomObjects3 arg0) throws Exception {
				return getRow(arg0);
			}

			private Row getRow(SomeRandomObjects3 s) {
				return RowFactory.create(s.id, s.status);
			}
		});

		// Creates schema
		StructType schema3 = DataTypes
				.createStructType(new StructField[] { DataTypes.createStructField("id", DataTypes.IntegerType, false),
						DataTypes.createStructField("status", DataTypes.StringType, false) });

		Dataset<Row> sparkStatus = spark.sqlContext().createDataFrame(rowRDD3, schema3).toDF();
		sparkStatus.show();

		person.createOrReplaceTempView("person");
		graduateProgram.createOrReplaceTempView("graduateProgram");
		sparkStatus.createOrReplaceTempView("sparkStatus");

		Dataset<Row> joinedDf = person.join(graduateProgram,
				person.col("graduate_program").equalTo((graduateProgram.col("id"))));
		joinedDf.show();
		sparkContext.close();
		spark.close();
	}
}

class SomeRandomObjects1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SomeRandomObjects1(int id, String name, int graduate_program, int[] spark_status) {
		super();
		this.id = id;
		this.name = name;
		this.graduate_program = graduate_program;
		this.spark_status = spark_status;
	}

	int id;
	String name;
	int graduate_program;
	int[] spark_status;
}

class SomeRandomObjects2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SomeRandomObjects2(int id, String degree, String department, String school) {
		super();
		this.id = id;
		this.degree = degree;
		this.department = department;
		this.school = school;
	}

	int id;
	String degree, department, school;
}

class SomeRandomObjects3 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SomeRandomObjects3(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	int id;
	String status;
}
