package com;

public class RotatedBinarySearch {
	// assume no duplicates , no pivot should be found , should take ologn time, it should be in ascending order
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int[] a1 = { 1, 2, 3, 4, 5, 6 };
		int[] a2 = { 6, 7, 1, 2, 3, 4, 5 };
		int[] a3 = { 5, 6, 7, 1, 2, 3, 4 };
		int[] a4 = { 5, 6, 1, 2, 3, 4 };
		int[] a5 = { 6, 5, 4, 3, 2, 1, 0 };
		int[] a6 = { 2, 1, 0, 6, 5, 4, 3 };
		System.out.println(rotated_binary_search(a, a.length, 7));
		System.out.println(rotated_binary_search(a1, a1.length, 3));
		System.out.println(rotated_binary_search(a2, a2.length, 4));
		System.out.println(rotated_binary_search(a3, a3.length, 5));
		System.out.println(rotated_binary_search(a4, a4.length, 6));
		System.out.println(rotated_binary_search(a5, a5.length, 4));
		System.out.println(rotated_binary_search(a6, a6.length, 0));
	}

	static int rotated_binary_search(int A[], int N, int key) {
		int L = 0;
		int R = N - 1;

		while (L <= R) {
			// Avoid overflow, same as M=(L+R)/2
			int M = L + ((R - L) / 2);
			if (A[M] == key)
				return M;

			// the bottom half is sorted
			if (A[L] <= A[M]) {
				if (A[L] <= key && key < A[M])
					R = M - 1;
				else
					L = M + 1;
			}
			// the upper half is sorted
			else {
				if (A[M] < key && key <= A[R])
					L = M + 1;
				else
					R = M - 1;
			}
		}
		return -1;
	}
}
