package com;

public class Given_an_array_find_the_maximum_j_and_i_such_that_arrj_isgreater_than_arri {

	public static void main(String[] args) {
		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		int n = arr.length;
		int maxDiff = maxIndexDiff(arr, n);
		System.out.println("\n " + maxDiff);
	}

	static int max(int x, int y) {
		return x > y ? x : y;
	}

	static int min(int x, int y) {
		return x < y ? x : y;
	}

	/*
	 * For a given array arr[], returns the maximum j – i such that arr[j] >
	 * arr[i]
	 */
	static int maxIndexDiff(int arr[], int n) {
		int maxDiff;
		int i, j;

		int LMin[] = new int[n];
		int RMax[] = new int[n];

		/*
		 * Construct LMin[] such that LMin[i] stores the minimum value from
		 * (arr[0], arr[1], ... arr[i])
		 */
		LMin[0] = arr[0];
		for (i = 1; i < n; ++i) {
			System.out.println("arr[i] is:" + arr[i] + " and i-1 is:" + (i - 1)
					+ "and LMIN[I-1] is:" + LMin[i - 1]);
			LMin[i] = min(arr[i], LMin[i - 1]);
		}
		/*
		 * Construct RMax[] such that RMax[j] stores the maximum value from
		 * (arr[j], arr[j+1], ..arr[n-1])
		 */
		RMax[n - 1] = arr[n - 1];
		for (j = n - 2; j >= 0; --j) {
			System.out.println("arr[j] is:" + arr[j] + " and j+1 is:" + (j + 1)
					+ "and RMax[j + 1] is:" + RMax[j + 1]);

			RMax[j] = max(arr[j], RMax[j + 1]);
		}
		/*
		 * Traverse both arrays from left to right to find optimum j - i This
		 * process is similar to merge() of MergeSort
		 */
		i = 0;
		j = 0;
		maxDiff = -1;
		while (j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return maxDiff;
	}

	// Time Complexity: O(n)
	// Auxiliary Space: O(n)
}
