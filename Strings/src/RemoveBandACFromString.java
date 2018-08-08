
public class RemoveBandACFromString {

	public static void main(String[] args) {
		stringFilter("aaac".toCharArray());
		stringFilter("acbac".toCharArray());
		stringFilter("ababaac".toCharArray());
	}

	public static void stringFilter(char str[]) {
		int n = str.length;

		int i = -1; // previous character
		int j = 0; // current character

		while (j < n) {
			/* check if current and next character forms ac */
			if (j < n - 1 && str[j] == 'a' && str[j + 1] == 'c')
				j += 2;

			/* if current character is b */
			else if (str[j] == 'b')
				j++;

			/*
			 * if current char is 'c && last char in output is 'a' so delete
			 * both
			 */
			else if (i >= 0 && str[j] == 'c' && str[i] == 'a') {
				i--;
				j++;
			}

			/* else copy curr char to output string */
			else
				str[++i] = str[j++];
		}
		for (++i; i < n; i++) {
			str[i] = 0;
		}
		System.out.println("" + new String(str));
	}

}
