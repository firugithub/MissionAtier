package com;

public class Maximum_size_sub_matrix_with_all_1s_in_a_binary_matrix {

	public static void main(String[] args) {
		int M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };
		System.out.println(M.length);
		printMaxSubSquare(M);
	}

	private static void printMaxSubSquare(int[][] matrix) {
		int R = matrix.length;
		int C = matrix[0].length;
		int ref[][] = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			ref[0][i] = matrix[0][i];
		}
		for (int j = 1; j < matrix.length; j++) {
			ref[j][0] = matrix[j][0];
		}
		/* Construct other entries of S[][] */
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (matrix[i][j] == 1)
					ref[i][j] = min(ref[i][j - 1], ref[i - 1][j],
							ref[i - 1][j - 1]) + 1;
				else
					ref[i][j] = 0;
			}
		}
		/*
		 * Find the maximum entry, and indexes of maximum entry in S[][]
		 */
		int max_of_s = ref[0][0];
		int max_i = 0;
		int max_j = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (max_of_s < ref[i][j]) {
					max_of_s = ref[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}

		System.out.println("\n Maximum size sub-matrix is: \n");
		for (int i = max_i; i > max_i - max_of_s; i--) {
			for (int j = max_j; j > max_j - max_of_s; j--) {
				System.out.println(matrix[i][j]);
			}
			System.out.println("\n");
		}
	}

	static/* UTILITY FUNCTIONS */
	/* Function to get minimum of three values */
	int min(int a, int b, int c) {
		int m = a;
		if (m > b)
			m = b;
		if (m > c)
			m = c;
		return m;
	}

}
