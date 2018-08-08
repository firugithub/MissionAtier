package com;

public class Matrix_Spiral_print {
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 },
				{ 13, 14, 15, 16, 17, 18 } };
		printMatrixInSpiral(a);
	}

	private static void printMatrixInSpiral(int[][] m) {
		int rows = m.length;
		int col = m[0].length;

		int r = 0, c = 0;
		while (r < rows && c < col) {
			for (int i = c; i < col; i++) {
				System.out.println(m[r][i]);
			}
			r++;
			for (int i = r; i < rows; i++) {
				System.out.println(m[i][col - 1]);
			}
			col--;

			if (r < rows) {
				for (int i = col - 1; i >= c; i--) {
					System.out.println(m[rows - 1][i]);
				}
				rows--;
			}
			if(c<col)
			{
				for (int i = rows-1; i >= r; i--) {
					System.out.println(m[i][c]);
				}
				c++;
			}
		}
	}
}
