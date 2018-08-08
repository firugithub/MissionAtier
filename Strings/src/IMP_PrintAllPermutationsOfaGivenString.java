public class IMP_PrintAllPermutationsOfaGivenString {

	/*
	 * Algorithm Paradigm: Backtracking Time Complexity: O(nn!)
	 */
	public static void main(String[] args) {
		String str = "ABC";
		permute(str.toCharArray(), 0, 2);

	}

	/*
	 * Function to print permutations of string This function takes three
	 * parameters: 1. String 2. Starting index of the string 3. Ending index of
	 * the string.
	 */
	static void permute(char[] a, int i, int n) {
		int j;
		char temp;
		if (i == n)
			System.out.println(a);
		else {
			for (j = i; j <= n; j++) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;

				permute(a, i + 1, n);
				
				temp = a[i];
				a[i] = a[j];
				a[j] = temp; // backtrack
			}
		}
	}

}
