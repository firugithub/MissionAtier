package com;

public class CoinChange {
	static int count(int S[], int m, int n) {
		// table[i] will be storing the number of solutions for
		// value i. We need n+1 rows as the table is consturcted
		// in bottom up manner using the base case (n = 0)
		int table[] = new int[n + 1];

		// Initialize all table values as 0
		int k = 0;
		while (k < n + 1) {
			table[k] = 0;
			k++;
		}

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[] values
		// after the index greater than or equal to the value of the
		// picked coin
		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++) {
				System.out.println("j is:" + j + "table[j] =" + table[j]);
				System.out.println("table[" + j + " - " + S[i] + "]");
				table[j] += table[j - S[i]];

				System.out.println("table[j] =" + table[j]);
			}
		return table[n];
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		int n = 4;
		System.out.println(count(arr, m, n));
	}
}
