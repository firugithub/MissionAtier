package com;

public class MajorityElementInSortedArray {
	// Linearly search for the first occurrence of the element, once you find it
	// (let at index i), check element at index i + n/2. If element is present
	// at i+n/2 then return 1 else return 0.

	static boolean isMajority(int arr[], int n, int x) {
		int i;

		/* get last index according to n (even or odd) */
		int last_index = (n % 2 == 0) ? (n / 2 + 1) : (n / 2);

		/* search for first occurrence of x in arr[] */
		for (i = 0; i < last_index; i++) {
			/* check if x is present and is present more than n/2 times */
			if (arr[i] == x && arr[i + n / 2] == x)
				return true;
		}
		return false;
	}

	/* Driver program to check above function */
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 4, 4, 4,4 };
		int n = arr.length;
		int x = 4;
		if (isMajority(arr, n, x))
			System.out.println(x + "   appear more than" + n / 2
					+ " times in arr[]");
		else
			System.out.println(x + " does not appear more than" + n / 2
					+ " times in arr[]");

	}
}
