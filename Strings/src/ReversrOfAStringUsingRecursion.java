public class ReversrOfAStringUsingRecursion {

	public static void main(String[] args) {
		reverse("kaushik");
		reverse2("kaushik".toCharArray());
	}

	public static void reverse(String s) {
		reverseInternal(s, s.length() - 1);
	}

	public static void reverseInternal(String s, int lastChar) {
		System.out.print(s.charAt(lastChar));
		if (lastChar != 0) {
			reverseInternal(s, lastChar - 1);
		}
	}

	public static void reverse2(char[] str) {
		char temp;
		int begin = 0, end = str.length - 1;
		while (begin < end) {
			temp = str[begin];
			str[begin] = str[end];
			str[end] = temp;
			begin++;end--;
		}
		System.out.println("\n"+String.valueOf(str));
	}
}
