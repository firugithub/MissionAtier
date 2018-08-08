
public class ReverseWordsInAGivenString {

	public static void main(String[] args) {
		char s[] = "i like this program very much".toCharArray();
		reverseWords(s, 0, s.length - 1);
		System.out.println(String.valueOf(s));
	}

	/* Function to reverse words */
	static void reverseWords(char[] s, int begin, int end) {
		int word_begin = begin;
		int temp = begin; /* temp is for word boundry */

		/* STEP 1 of the above algorithm */
		while (temp <= end) {
			  if (s[temp] == ' ') {
				reverse(s, word_begin, temp - 1);
				word_begin = temp + 1;
			}
			temp++;
		} /* End of while */
		if (temp==end+1) {
			reverse(s, word_begin, temp - 1);
		}

		/* STEP 2 of the above algorithm */
		reverse(s, begin, end);
	}

	/* UTILITY FUNCTIONS */
	/*
	 * Function to reverse any sequence starting with pointer begin and ending
	 * with pointer end
	 */
	public static void reverse(char[] str, int begin, int end) {
		char temp;
		while (begin < end) {
			temp = str[begin];
			str[begin] = str[end];
			str[end] = temp;
			begin++;
			end--;
		}
	}

}
