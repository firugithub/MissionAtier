import java.util.Arrays;

public class AllPermutationsWithRepetitions {
	public static void main(String[] args) {
		char arr[] = "ABC".toCharArray();
		// allLexicographic(arr, arr.length, "");
		allLexicographic(arr);
	}

	// public static void recur(char arr[], int n, String s) {
	// if (s.length() == n) {
	// System.out.println(s);
	// return;
	// }
	// for (int i = 0; i < n; i++) {
	// while (i < (n - 1) && arr[i] == arr[i + 1])
	// i++;
	// recur(arr, n, s + arr[i]);
	// }
	// }

	public static void allLexicographicRecur(char str[], char[] data, int last, int index) {
		int i, len = str.length;

		// One by one fix all characters at the given index and recur for
		// the/ subsequent indexes
		for (i = 0; i < len; i++) {
			// Fix the ith character at index and if this is not the last
			// index then recursively call for higher indexes
			data[index] = str[i];

			// If this is the last index then print the string stored in
			// data[]
			if (index == last)
				System.out.println(data);
			else // Recur for higher indexes
				allLexicographicRecur(str, data, last, index + 1);
		}
	}

	/*
	 * This function sorts input string, allocate memory for data (needed for
	 * allLexicographicRecur()) and calls allLexicographicRecur() for printing
	 * all permutations
	 */
	public static void allLexicographic(char[] str) {
		int len = str.length;

		char[] data = new char[len];

		Arrays.sort(str);

		// Now print all permutaions
		allLexicographicRecur(str, data, len - 1, 0);

	}
}
