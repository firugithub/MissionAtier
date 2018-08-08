
public class FileSplitTest {

	public static void main(String args[]) {
		String asd = "test.txt";
		System.out.println(getFileExtension(asd));
		System.out.println(asd.substring(0, asd.lastIndexOf(".")));
	}

	private static String getFileExtension(String file) {
		String name = file;
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}
}
