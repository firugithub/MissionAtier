public class StringMatchingToParticularPattern {

	private static String encode(String str) {
		if (null == str) {
			return null;
		}
		String encode = "";
		int i = 1;
		int arr[] = new int[26];
		for (char ch : str.toCharArray()) {
			if (arr[ch - 'a'] == 0) {
				arr[ch - 'a'] = i++;
			}
			encode += arr[ch - 'a'];
		}
		return encode;
	}

	public static void main(String[] args) {
		String[] dict = { "abb", "abc", "xyz", "xyy","mbm" };
		for (String str : dict) {
			if (encode("aba").equals(encode(str)))
				System.out.println(str);
		}

	}

}
