import java.util.Arrays;

public class PairOfCompleteStringsInTwoSetsOfString {
	public static void main(String[] args) {
		String set1[] = { "abcdefgh", "geeksforgeeks", "lmnopqrst", "abc" };
		String set2[] = { "ijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz", "defghijklmnopqrstuvwxyz" };
		name(set1, set2);
	}

	public static void name(String set1[], String set2[]) {

		long countS1[] = new long[set1.length];
		Arrays.fill(countS1, 0);
		long countS2[] = new long[set2.length];
		Arrays.fill(countS2, 0);
		// long countS3[] = new long[set2.length];
		// Arrays.fill(countS3, 0);
		for (int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set1[i].length(); j++) {
				countS1[i] = countS1[i] | (1 << set1[i].charAt(j) - 'a');
			}

		}
		for (int i = 0; i < set2.length; i++) {
			for (int j = 0; j < set2[i].length(); j++) {
				countS2[i] = countS2[i] | (1 << set2[i].charAt(j) - 'a');
			}
		}
		//
		// for (int j = 0; j < 26; j++) {
		// countS3[0] = countS3[0] | (1 <<
		// "abcdefghijklmnopqrstuvwxyz".charAt(j) - 'a');
		// }

		int count = 0;
		long complete = (1 << 26) - 1;
		for (int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				if ((countS1[i] | countS2[j]) == complete) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
