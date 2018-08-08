import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PrintAllTheDuplicatesInTheInputString {

	public static void main(String args[]) {
		String str = "The quick brown fox jumps over the lazy dog";
		String str2 = "geeksforgeeks";
		anotherMethod(str2.toCharArray());
	}

	public static void anotherMethod(char[] charArray) {
		int inputIndex = 0;
		Map<String, Integer> hash = new HashMap<String, Integer>();
		while (inputIndex < charArray.length) {
			if (!hash.containsKey(String.valueOf(charArray[inputIndex]))) {
				hash.put(String.valueOf(charArray[inputIndex]), 1);
			} else {
				System.out.println(charArray[inputIndex]);
				hash.put(String.valueOf(charArray[inputIndex]),
						hash.get(String.valueOf(charArray[inputIndex])) + 1);
			}
			inputIndex++;
		}
		for (Entry<String, Integer> entry : hash.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " count:"
						+ entry.getValue());
			}
		}
	}
	
}
