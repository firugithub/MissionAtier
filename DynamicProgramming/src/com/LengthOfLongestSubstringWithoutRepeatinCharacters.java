package com;

public class LengthOfLongestSubstringWithoutRepeatinCharacters {

	private static final int NO_OF_CHARS = 256;

	public static void main(String args[]) {
		String str = "geeksforgeeks";
		System.out.println(printTheLength(str.toCharArray()));
	}

	private static int printTheLength(char[] cs) {
		int visited[] = new int[NO_OF_CHARS];
		int cur_len = 1; // To store the lenght of current substring
		int max_len = 1; // To store the result
		int prev_index; // To store the previous index
		int i;
		for (i = 0; i < NO_OF_CHARS; i++) {
			visited[i] = -1;
		}
		visited[cs[0]] = 0;
		for (i = 1; i < cs.length; i++) {
			System.out.println(cs[i]);
			prev_index = visited[cs[i]];

			/*
			 * If the currentt character is not present in the already processed
			 * substring or it is not part of the current NRCS, then do
			 * cur_len++
			 */
			if (prev_index == -1 || i - cur_len > prev_index)
				cur_len++;

			/*
			 * If the current character is present in currently considered NRCS,
			 * then update NRCS to start from the next character of previous
			 * instance.
			 */
			else {
				/*
				 * Also, when we are changing the NRCS, we should also check
				 * whether length of the previous NRCS was greater than max_len
				 * or not.
				 */
				if (cur_len > max_len)
					max_len = cur_len;

				cur_len = i - prev_index;
			}

			visited[cs[i]] = i; // update the index of current character
		}

		// Compare the length of last NRCS with max_len and update max_len if
		// needed
		if (cur_len > max_len)
			max_len = cur_len;

		return max_len;
	}
}
