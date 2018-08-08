
public class Atoi {

	public static void main(String[] args) {
		char ch = 'a';
		char ch1 = '8';
		int i =ch;
		int i1 =ch1;
		int h=ch-'0';
		System.out.println(i);
		System.out.println(h);
		System.out.println(i1);
		System.out.println(myAtoi("89789"));

	}

	// A simple atoi() function
	static int myAtoi(String str) {
		int res = 0; // Initialize result

		// Iterate through all characters of input string and
		// update result
		for (int i = 0; i < str.length(); ++i)
			res = res * 10 + str.charAt(i)-'0' ;

		// return result.
		return res;
	}
}
