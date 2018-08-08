package com;

public class search_in_row_wise_and_column_wise_sorted_matrix {
	/*
	 * Time Complexity: O(n)
	 * 
	 * The above approach will also work for m x n matrix (not only for n x n).
	 * Complexity would be O(m + n).
	 */public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		search(mat, 4, 29);
	}

	static int search(int mat[][], int n, int x) {
		int i = 0, j = n - 1; // set indexes for top right element
		while (i < n && j >= 0) {
			System.out.println(" i and j are" + i + "    , j is:" + j);
			if (mat[i][j] == x) {
				System.out.println("\n Found at " + i + " , " + j);
				return 1;
			}
			if (mat[i][j] > x)
				j--;
			else
				// if mat[i][j] < x
				i++;
		}

		System.out.println("\n Element not found");
		return 0; // if ( i==n || j== -1 )
	}
}
