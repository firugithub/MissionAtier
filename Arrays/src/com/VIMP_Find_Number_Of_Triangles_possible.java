package com;

import java.util.Arrays;

public class VIMP_Find_Number_Of_Triangles_possible {

	public static void main(String[] args) {
		int arr[] = { 10, 21, 22, 100, 101, 200, 300 };

		System.out.println("Total number of triangles possible is  "
				+ findNumberOfTriangles(arr, arr.length));
	}

	// Function to count all possible triangles with arr[] elements
	static int findNumberOfTriangles(int arr[], int n) {
		// Sort the array elements in non-decreasing order
		Arrays.sort(arr);
		// Initialize count of triangles
		int count = 0;

		// Fix the first element. We need to run till n-3 as the other two
		// elements are
		// selected from arr[i+1...n-1]
		for (int i = 0; i < n - 2; ++i) {
			// Initialize index of the rightmost third element
			int k = i + 2;

			// Fix the second element
			for (int j = i + 1; j < n; ++j) {
				// Find the rightmost element which is smaller than the sum
				// of two fixed elements
				// The important thing to note here is, we use the previous
				// value of k. If value of arr[i] + arr[j-1] was greater than
				// arr[k],
				// then arr[i] + arr[j] must be greater than k, because the
				// array is sorted.
				System.out.println("Value of k is:"+k);
				while (k < n && arr[i] + arr[j] > arr[k])
					++k;

				// Total number of possible triangles that can be formed
				// with the two fixed elements is k - j - 1. The two fixed
				// elements are arr[i] and arr[j]. All elements between arr[j+1]
				// to arr[k-1] can form a triangle with arr[i] and arr[j].
				// One is subtracted from k because k is incremented one extra
				// in above while loop.
				// k will always be greater than j. If j becomes equal to k,
				// then
				// above loop will increment k, because arr[k] + arr[i] is
				// always
				// greater than arr[j]
				count += k - j - 1;
				System.out.println("Count is:"+count);
			}
		}

		return count;
	}
	/*
	 * Time Complexity: O(n^2). The time complexity looks more because of 3
	 * nested loops. If we take a closer look at the algorithm, we observe that
	 * k is initialized only once in the outermost loop. The innermost loop
	 * executes at most O(n) time for every iteration of outer most loop,
	 * because k starts from i+2 and goes upto n for all values of j. Therefore,
	 * the time complexity is O(n^2).
	 */
}
