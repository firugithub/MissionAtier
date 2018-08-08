public class RemoveAdjacentDuplicates {
	static char last_removed;

	public static void main(String[] args) {
		System.out.println(removeDuplicate("geeksforgeeg"));
		System.out.println(removeDuplicate("azxxxzy"));
		System.out.println(removeDuplicate("caaabbbaac"));
		System.out.println(removeDuplicate("gghhg"));
		System.out.println(removeDuplicate("aaaacddddcappp"));
		System.out.println(removeDuplicate("aaaaaaaaaa"));
		System.out.println(removeDuplicate("qpaaaaadaaaaadprq"));
		System.out.println(removeDuplicate("acaaabbbacdddd"));
		System.out.println(removeDuplicate("acbbcddc"));
		
		System.out.println(removeDuplicate("aabcccdee"));
		System.out.println(removeDuplicate("abcdeedcbfg"));

	}

	public static String removeDuplicate(String s) {
		if (s.isEmpty()) {
			return s;
		}
		char[] buf = s.toCharArray();
		char lastchar = buf[0];

		// i: index of input char
		// o: index of output char
		int o = 1;
		for (int i = 1; i < buf.length; i++) {
			if (o > 0 && buf[i] == buf[o - 1]) {
				lastchar = buf[o - 1];
				while (o > 0 && buf[o - 1] == lastchar) {
					o--;
				}
			} else if (buf[i] == lastchar) {
				// Don't copy to output
			} else {
				buf[o++] = buf[i];
			}
		}
		return new String(buf, 0, o);
	}

}
