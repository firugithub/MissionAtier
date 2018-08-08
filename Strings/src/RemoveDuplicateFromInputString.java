import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateFromInputString {
	public static void main(String args[]) {
		String str = "The quick brown fox jumps over the lazy dog";
		String str2 = "geeksforgeeks";
		String finalStr = "";
		for (char a : str2.toCharArray()) {
			if (!finalStr.contains("" + a)) {
				finalStr = finalStr + a;
			}
		}
		System.out.println(finalStr);
		System.out.println(anotherMethod(str2.toCharArray()));
	}

	public static String anotherMethod(char[] charArray) {
		int inputIndex = 0, resiudalIndex = 0;
		Map<String, Integer> hash = new HashMap<String, Integer>();
		while (inputIndex < charArray.length) {
			if (!hash.containsKey(String.valueOf(charArray[inputIndex]))) {
				hash.put(String.valueOf(charArray[inputIndex]), 1);
				charArray[resiudalIndex] = charArray[inputIndex];
				resiudalIndex++;
			}
			inputIndex++;
		}
		for (int i = resiudalIndex; i < charArray.length; i++) {
			charArray[i] = '\0';
		}
		return String.valueOf(charArray);
	}
}
