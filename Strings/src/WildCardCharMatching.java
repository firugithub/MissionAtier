public class WildCardCharMatching {
	// The main function that checks if two given strings match. The first
	// string may contain wildcard characters
	static boolean match(String first, String second, int start1, int start2) {
		// If we reach at the end of both strings, we are done
		if (first.substring(start1, first.length()-1).length() == 0
				&& second.substring(start1, first.length()-1).length() == 0)
			return true;

		// Make sure that the characters after '' are present in second string.
		// This function assumes that the first string will not contain two
		// consecutive ''
		if (first.charAt(start1) == '*' && (start1 + 1 < first.length())
				&& start2 > second.length() - 1)
			return false;

		// If the first string contains '?', or current characters of both
		// strings match
		if (first.charAt(start1) == '?'
				|| first.charAt(start1) == second.charAt(start2))
			return match(first, second, start1 + 1, start2 + 1);

		// If there is , then there are two possibilities
		// a) We consider current character of second string
		// b) We ignore current character of second string.
		if (first.charAt(start1) == '*')
			return match(first, second, start1 + 1, start2)
					|| match(first, second, start1, start2 + 1);
		return false;
	}

	// A function to run test cases
	static void test(String string, String string2) {
		System.out.println(match(string, string2, 0, 0));
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		test("g*ks", "geeks"); // Yes
		test("ge?ks*", "geeksforgeeks"); // Yes
		test("g*k", "gee"); // No because 'k' is not in second
		test("*pqrs", "pqrst"); // No because 't' is not in first
		test("abc*bcd", "abcdhghgbcd"); // Yes
		test("abc*c?d", "abcd"); // No because second must have 2 instances of
									// 'c'
		test("*c*d", "abcd"); // Yes
		test("*?c*d", "abcd"); // Yes
		test("*ba*ab", "baaabab"); // Yes
	}
}
