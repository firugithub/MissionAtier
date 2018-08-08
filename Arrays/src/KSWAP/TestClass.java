package KSWAP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class TestClass {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = "";
		int numOfSwaps = 0;

		try {
			number = br.readLine().trim();
			numOfSwaps = Integer.parseInt(br.readLine().trim());

			BigInteger bigInteger = new BigInteger(number);
			BigInteger bi1, bi2;

			bi1 = new BigInteger("0");
			bi2 = new BigInteger("1000000000000");
			if (bigInteger.compareTo(bi1) == -1 || bigInteger.compareTo(bi2) == 1) {
				System.out.println("Incorrect Input");
			}
			int[] input = new int[number.length()];
			try {
				for (int i = 0; i < number.length(); i++) {
					input[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
					System.out.print(input[i]);
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("Incorrect Input");
			}

			System.out.println(getMaxNumber(input, numOfSwaps));
		} catch (Exception e) {
			System.out.println("Incorrect Input");
		}
	}

	private static String getMaxNumber(int[] number, int numOfSwaps) {
		int start = 0;
		int max = 0;
		while (numOfSwaps > 0 && start < number.length) {
			max = start;
			for (int i = start + 1; i < start + numOfSwaps && i < number.length; i++) {
				if (number[i] > number[max]) {
					max = i;
				}
			}

			// swap
			if (max != start) {
				int temp = number[max];
				for(int i=max;i>start;i--)
				{
					number[i]=number[i-1];
				}
				//number[max] = number[start];
				number[start] = temp;
				numOfSwaps -= max - start;
			}
			start++;
		}

		String res = "";
		for (int i = 0; i < number.length; i++) {
			res += number[i];
		}

		return res;
	}
}