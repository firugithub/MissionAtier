import java.util.HashMap;
import java.util.Map;

public class MobileKeypad {
	static Map<Integer, String> hashTable = new HashMap<Integer, String>();

	// A recursive function to print all possible words that can be obtained
	// by input number[] of size n. The output words are one by one stored
	// in output[]
	public static void printWordsUtil(int number[], int curr_digit, char output[], int n) {
		// Base case, if current output word is prepared
		int i;
		if (curr_digit == n) {
			System.out.println(String.valueOf(output));
			return;
		}

		// Try all 3 possible characters for current digir in number[]
		// and recur for remaining digits
		for (i = 0; i < hashTable.get(number[curr_digit]).length(); i++) {
			output[curr_digit] = hashTable.get(number[curr_digit]).charAt(i);
			printWordsUtil(number, curr_digit + 1, output, n);
			if (number[curr_digit] == 0 || number[curr_digit] == 1)
				return;
		}
	}

	// A wrapper over printWordsUtil(). It creates an output array and
	// calls printWordsUtil()
	static void printWords(int number[], int n) {
		char[] result = new char[n + 1];
		result[n] = 0;
		printWordsUtil(number, 0, result, n);
	}

	// Driver program
	public static void main(String args[]) {

		hashTable.put(0, "");
		hashTable.put(1, "");
		hashTable.put(2, "abc");
		hashTable.put(3, "def");
		hashTable.put(4, "ghi");
		hashTable.put(5, "jkl");
		hashTable.put(6, "mno");
		hashTable.put(7, "pqrs");
		hashTable.put(8, "tuv");
		hashTable.put(9, "wxyz");

		int number[] = {4, 2, 3 };
		int n = number.length;
		printWords(number, n);
	}

}
