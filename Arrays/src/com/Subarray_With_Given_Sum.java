package com;

public class Subarray_With_Given_Sum {

	public static void main(String[] args) {
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 0, 23 };
		int n = arr.length;
		int sum = 23;
		subArraySum(arr, n, sum);
	}

	/*
	 * Returns true if the there is a subarray of arr[] with sum equal to 'sum'
	 * otherwise returns false. Also, prints the result
	 */
	static int subArraySum(int arr[], int n, int sum) {
		/*
		 * Initialize curr_sum as value of first element and starting point as 0
		 */
		int curr_sum = arr[0], start = 0, i;

		/*
		 * Add elements one by one to curr_sum and if the curr_sum exceeds the
		 * sum, then remove starting element
		 */
		for (i = 1; i < n; i++) {
			// Add this element to curr_sum
			curr_sum = curr_sum + arr[i];

			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start < i) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum, then return true
			if (curr_sum == sum) {
				System.out.println("Sum found between indexes:" + start
						+ " and" + (i));
				curr_sum = curr_sum - arr[start];
				start++;

			}
		}

		// If we reach here, then no subarray
		System.out.println("No subarray found");
		return 0;
	}
	/*
	 * Given an unsorted array of nonnegative integers, find a continous
	 * subarray which adds to a given number.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33 Ouptut: Sum found between
	 * indexes 2 and 4
	 * 
	 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7 Ouptut: Sum found between
	 * indexes 1 and 4
	 * 
	 * Input: arr[] = {1, 4}, sum = 0 Output: No subarray found There may be
	 * more than one subarrays with sum as the given sum. The following
	 * solutions print all such subarray.
	 */

	/*
	 * Another solution time complexity is O(n) and space complexity is O(n)
	 * 
	 * hash the sum from 0 to i for all array elements, i.e sum[i] = sum of all
	 * elements from a[0] to a[i] and corresponding index as data to key
	 * (starting from -1 to n)
	 * 
	 * ex: 2 3 -4 9 -1 -7 -5 6 5
	 * 
	 * sum to enter in hash table : 0 2 5 1 10 9 2 -3 3 8 index to enter in hash
	 * table: -1 0 1 2 3 4 5 6 7 8
	 * 
	 * hash sum as key and its corresponding index as data. and while hashing
	 * check if any sum is already exists in hash table
	 * 
	 * here there is one duplicate number that is 2 in sum array... the indexes
	 * of duplicate numbers is 0 and 5, so we need to take sum from index 1 to 5
	 * in original array that is 3 to -7
	 * 
	 * if there are no duplicates in sum array then sub-array with sum ZERO
	 * doesn't exists in given array
	 */
}
