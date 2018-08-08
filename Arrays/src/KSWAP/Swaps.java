package KSWAP;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swaps {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String kString = br.readLine();
		int length = line.length();
		int[] digits = new int[length];
		for (int i = 0; i < length; i++) {
			digits[i] = Integer.parseInt(line.substring(i, i + 1));
		}
		int k = Integer.parseInt(kString);
		int start = -1;
		int end = digits.length;
		int index;
		while (k != 0 && start < end) {
			start++;
			index = findMaxIndex(digits, start, Math.min(end - 1, k));
			if (index == -1) {
				continue;
			}
			int temp = digits[index];
			for (int i = index; i > start; i--) {
				digits[i] = digits[i - 1];

			}
			digits[start] = temp;

			k = k - (index - start) + 1;

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < end; i++) {
			sb.append(digits[i]);
		}
		System.out.println(sb.toString());

	}

	public static int findMaxIndex(int[] digits, int start, int end) {
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = start; i <= end; i++) {
			if (max < digits[i]) {
				max = digits[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

}