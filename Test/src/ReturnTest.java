
public class ReturnTest {

	public static void main(String[] args) {
		returnAnyValue("a");
	}

	private static int returnAnyValue(String a) {
		if (null == a) {
			return -1;
		} else
			return 1;
	}

}
