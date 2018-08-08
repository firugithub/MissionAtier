public class Imp_RemoveAdjacentDuplicatesInAString {

	public static void main(String args[]) {
		String str10 = "hahhaaha";
		System.out.println(remove(str10, 0));
		String str2 = "azxxxzy";
		System.out.println(remove(str2, 0));
		String str1 = "geeksforgeeg";
		System.out.println(remove(str1, 0));

		String str3 = "caaabbbaac";
		System.out.println(remove(str3, 0));

		String str4 = "gghhg";
		System.out.println(remove(str4, 0));

		String str5 = "aaaacddddcappp";
		System.out.println(remove(str5, 0));

		String str6 = "aaaaaaaaaa";
		System.out.println(remove(str6, 0));

		String str7 = "qpaaaaadaaaaadprq";
		System.out.println(remove(str7, 0));

		String str8 = "acaaabbbacdddd";
		System.out.println(remove(str8, 0));

		String str9 = "acbbcddc";
		System.out.println(remove(str9, 0));

	}

	private static String remove(String str, int startIndex) {
		String str1 = str.substring(startIndex);
		int len = str1.length();
		if (len == 0 || len == 1) {
			return str1;
		}
		if (str1.charAt(0) == str1.charAt(1)) {
			int i = 0;
			for (i = 2; i < len; i++) {
				if (str1.charAt(i) != str1.charAt(0)) {
					break;
				}
			}
			str1 = remove(str,i);
		} else {
			str1 = str1.charAt(0) + remove(str,1);
		}

		if (str1.length() > 1) {
			if (str1.length() > 2) {
				if (str1.charAt(0) == str1.charAt(1)) {
					int i = 0;
					for (i = 2; i < len; i++) {
						if (str1.charAt(i) != str1.charAt(0)) {
							break;
						}
					}
					str1 = str1.substring(i);
				}
			} else {
				if (str1.charAt(0) == str1.charAt(1)) {
					return "";
				} else {
					return str1;
				}

			}
		}
		return str1;
	}
}