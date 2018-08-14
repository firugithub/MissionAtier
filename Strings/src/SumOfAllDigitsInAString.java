
public class SumOfAllDigitsInAString {

	private static int getSumFromString(String str) {
		if (null == str || str.length() < 1) {
			return -1;
		}
		int sum = 0;
		String res = "";
		for (Character ch : str.toCharArray()) {
			if (Character.isDigit(ch)) {
				res += ch;
			} else {
				if (res.length() > 0) {
					sum += Integer.valueOf(res);
					res = "";
				}
			}
		}
		if (res.length() > 0) {
			sum += Integer.valueOf(res);
		}
		return sum;
	}

	public static void main(String args[]) {
		System.out.println(getSumFromString("12abc20yz68"));
	}
}
