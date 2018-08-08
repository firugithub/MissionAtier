
public class CountNoOfWordsInAString {

	public static void main(String[] args) {
		System.out.println(getWordCount("One two          three\n  four\nfive  ".toCharArray()));
		System.out.println(getWordCount(" One ".toCharArray()));
		System.out.println(getWordCount("One ".toCharArray()));
	}

	static int isInvalid(char p) {
		if ((p == ' ') || (p == '\n') || (p == '\t'))
			return 1;
		return 0;
	}

	static int getWordCount(char[] string) {
		int wc = 0;
		int count = 0;
		while (true) {
			while (count <= string.length - 1 && isInvalid(string[count]) == 1)
				count++;
			if (count > string.length - 1)
				break;
			wc++;
			while (count <= string.length - 1 && isInvalid(string[count]) == 0)
				count++;
		}
		return wc;
	}

}
