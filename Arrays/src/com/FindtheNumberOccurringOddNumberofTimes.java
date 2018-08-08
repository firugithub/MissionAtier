package com;

public class FindtheNumberOccurringOddNumberofTimes {
	/*
	 * Algorithm: Do bitwise XOR of all the elements. Finally we get the number
	 * which has odd occurrences.
	 */

	static int getOddOccurrence(int ar[], int ar_size) {
		int i;
		int res = 0;
		for (i = 0; i < ar_size; i++)
			{System.out.println(ar[i] +"............."+ res);
			res = res ^ ar[i];
System.out.println(res);}
		return res;
	}

	/* Diver function to test above function */
	public static void main(String[] args) {

		{
			int ar[] = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
			int n = ar.length;
			System.out.println(getOddOccurrence(ar, n));
		}

		// Time Complexity: O(n)

	}
}
