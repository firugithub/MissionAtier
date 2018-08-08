package com;

import java.util.Arrays;

public class Maximum_path_sum_position_jumps_divisibility_condition {

	static void printMaxSum(int arr[], int n) {
		// Create an array such that dp[i]
		// stores maximum path sum ending with i.
		int dp[] = new int[n];
		Arrays.fill(dp, 0);

		// Calculating maximum sum
		// path for each element.
		for (int i = 0; i < n; i++) {
			dp[i] = arr[i];

			// Finding previous step for arr[i]
			// Moving from 1 to sqrt(i+1) since all the
			// divisors are present from sqrt(i+1).
			int maxi = 0;
			for (int j = 1; j <= Math.sqrt(i + 1); j++) {

				// Checking if j is divisor of i+1.
				if (((i + 1) % j == 0) && (i + 1) != j) {

					// Checking which divisor will
					// provide greater value.
					if (dp[j - 1] > maxi)
						maxi = dp[j - 1];
					if (dp[(i + 1) / j - 1] > maxi && j != 1)
						maxi = dp[(i + 1) / j - 1];
				}
			}

			dp[i] += maxi;
		}

		// Printing the answer (Maximum path sum
		// ending with every position i+1.)
		for (int i = 0; i < n; i++)
			System.out.print(dp[i] + " ");
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 2, 3, 1, 4, 6, 5 };
		int n = arr.length;

		// Function calling
		printMaxSum(arr, n);
	}
}