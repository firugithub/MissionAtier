package com;

import java.util.Arrays;

public class TwoElementsWithSumXInAnArray {
	static boolean hasArrayTwoCandidates(int A[], int arr_size, int sum) {
		int l, r;

		/* Sort the elements */

		Arrays.sort(A);

		// quickSort(A, 0, arr_size-1);

		/*
		 * Now look for the two candidates in the sorted array
		 */
		l = 0;
		r = arr_size - 1;
		while (l < r) {
			if (A[l] + A[r] == sum)
				return true;
			else if (A[l] + A[r] < sum)
				l++;
			else
				// A[i] + A[j] > sum
				r--;
		}
		return false;
	}

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, -8 };
		int n = 16;
		int arr_size = 6;

		if (hasArrayTwoCandidates(A, arr_size, n))
			System.out.println("Array has two elements with sum 16");
		else
			System.out.println("Array doesn't have two elements with sum 16 ");

	}

}
