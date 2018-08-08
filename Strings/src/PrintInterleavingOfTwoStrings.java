
public class PrintInterleavingOfTwoStrings {

	public static void main(String[] args) {
		char str1[] = "AB".toCharArray();
		char str2[] = "CD".toCharArray();
		printIls(str1, str2, str1.length, str2.length);
	}

	private static void printIls(char[] str1, char[] str2, int length, int length2) {
		char[] result = new char[length + length2];
		printIlsUtil(str1, str2, result, length, length2, 0);
	}

	private static void printIlsUtil(char[] str1, char[] str2, char[] result, int length, int length2, int i) {

		if (length == 0 && length2 == 0) {
			System.out.println(String.valueOf(result));
		}

		if (length != 0) {
			result[i] = str1[0];
			printIlsUtil(String.copyValueOf(str1, 1, str1.length-1).toCharArray(), str2, result, length - 1, length2,
					i + 1);
		}
		if (length2 != 0) {
			result[i] = str2[0];
			printIlsUtil(str1, String.copyValueOf(str2, 1, str2.length-1).toCharArray(), result, length, length2 - 1,
					i + 1);
		}
	}

}
