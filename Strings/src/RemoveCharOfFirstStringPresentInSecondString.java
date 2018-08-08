public class RemoveCharOfFirstStringPresentInSecondString {
	public static void main(String[] args) {
		String first = "arpit";
		String second = "tp";
		boolean bit[] = new boolean[256]; // boolean are defaulted to false

		for (int i = 0; i < second.length(); i++) {
			bit[second.charAt(i)] = true;
		}

		char[] result = new char[first.length()];

		for (int i = 0, j = 0; i < first.length(); i++) {
			if (bit[first.charAt(i)] == false) {
				result[j] = first.charAt(i);
				j++;
			}

		}

		String resultstr = new String(result);
		System.out.println("Result - " + resultstr);
	}
}
