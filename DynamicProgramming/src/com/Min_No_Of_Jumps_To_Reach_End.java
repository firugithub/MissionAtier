package com;

public class Min_No_Of_Jumps_To_Reach_End {

	// Returns minimum number of jumps to reach arr[n-1] from arr[0]
	static int minJumps(int arr[], int n) {
		int jumps[] = new int[n]; // jumps[n-1] will hold the result
		int i, j;

		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;

		jumps[0] = 0;

		// Find the minimum number of jumps to reach arr[i]
		// from arr[0], and assign this value to jumps[i]
		for (i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j]) {
					jumps[i] = min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		return jumps[n - 1];
	}

	private static int min(int x, int y) {
		return (x < y) ? x : y;
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int arr[] = { 1, 3, 6, 1, 0, 9 };
		int arr2[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println("Minimum number of jumps to reach end is  "
				+ minJumps(arr, arr.length));
		System.out.println("Minimum number of jumps to reach end is  "
				+ minJumps(arr2, arr2.length));
	}
}
