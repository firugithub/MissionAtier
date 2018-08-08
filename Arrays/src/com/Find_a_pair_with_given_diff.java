package com;

public class Find_a_pair_with_given_diff {
	/*
	 * The second step of the above algorithm can be improved to O(n). The first
	 * step remain same. The idea for second step is take two index variables i
	 * and j, initialize them as 0 and 1 respectively. Now run a linear loop. If
	 * arr[j] – arr[i] is smaller than n, we need to look for greater arr[j], so
	 * increment j. If arr[j] – arr[i] is greater than n, we need to look for
	 * greater arr[i], so increment i. Thanks to Aashish Barnwal for suggesting
	 * this approach. The following code is only for the second step of the
	 * algorithm, it assumes that the array is already sorted.
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 8, 30, 40, 100 };
		int n = 60;
		findPair(arr, arr.length, n);
	}

	// The function assumes that the array is sorted
	static boolean findPair(int arr[], int size, int n) {
		// Initialize positions of two elements
		int i = 0;
		int j = 1;

		// Search for a pair
		while (i < size && j < size) {
			if (i != j && arr[j] - arr[i] == n) {
				System.out.println("Pair Found:" + arr[i] + "," + arr[j]);
				return true;
			} else if (arr[j] - arr[i] < n)
				j++;
			else
				i++;
		}

		System.out.println("No such pair");
		return false;
	}
}
