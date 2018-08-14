import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import com.google.common.collect.ImmutableList;

public class CreateARowInSpark {
	public static void main(String[] args) {

		SparkSession spark = SparkSession.builder().config("spark.master", "local").getOrCreate();
		List<StructField> inputFields = new ArrayList<>();
		inputFields.add(DataTypes.createStructField("some", DataTypes.StringType, true));
		inputFields.add(DataTypes.createStructField("col", DataTypes.StringType, true));
		inputFields.add(DataTypes.createStructField("names", DataTypes.LongType, true));
		StructType inputSchema = DataTypes.createStructType(inputFields);

		Row myRow = RowFactory.create("Hello", "None", 1l);
		List<Row> rowList = ImmutableList.of(myRow);
		String[] cols = spark.createDataFrame(rowList, inputSchema).columns();
		Dataset<Row> df = spark.createDataFrame(rowList, inputSchema);
		System.out.println(df.first().getString(0));
		List<Row> details3 =  df.collectAsList();
		System.out.println(details3.toString());
		Arrays.stream(cols).forEach(num -> System.out.println(num));
	}
}
