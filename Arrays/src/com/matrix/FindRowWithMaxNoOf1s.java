package com.matrix;

public class FindRowWithMaxNoOf1s {
	/*
	 * find the row with max no of 1's A function to find the index of first
	 * index of 1 in a boolean array arr[]
	 */
	static int first(int arr[], int low, int high) {
		if (high >= low) {
			// get the middle index
			int mid = low + (high - low) / 2;

			// check if the element at middle index is first 1
			if ((mid == 0 || arr[mid - 1] == 0) && arr[mid] == 1)
				return mid;

			// if the element is 0, recur for right side
			else if (arr[mid] == 0)
				return first(arr, (mid + 1), high);

			else
				// If element is not first 1, recur for left side
				return first(arr, low, (mid - 1));
		}
		return -1;
	}

	public static void main(String args[]) {
		int mat[][] = { { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
				{ 0, 0, 0, 0 } };

		System.out.println("Index of row with maximum 1s is :"
				+ rowWithMax1s(mat));
	}

	private static int rowWithMax1s(int[][] mat) {
		// Initialize first row as row with max 1s
		int max_row_index = 0;
		int C = mat[0].length;
		// The function first() returns index of first 1 in row 0.
		// Use this index to initialize the index of leftmost 1 seen so far
		int j = first(mat[0], 0, C - 1);
		if (j == -1) // if 1 is not present in first row
			j = C - 1;
		else if (j == 0) // first row has all 1s and hence we are done
			return max_row_index;
		else
			j--; // go to one position left from leftmost 1

		for (int i = 1; i < mat.length; i++) {
			// Move left until a 0 is found
			while (j >= 0 && mat[i][j] == 1) {
				j = j - 1; // Update the index of leftmost 1 seen so far
				max_row_index = i; // Update max_row_index
			}
		}
		return max_row_index;
	}
}
