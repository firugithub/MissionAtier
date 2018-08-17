package arraysnew;

import java.util.HashMap;
import java.util.Map;

public class SurpasserCount {
	private static void merge(int arr[], int l, int m, int r, Map<Integer, Integer> hm) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		/* create temp arrays */
		int L[] = new int[n1], R[] = new int[n2];

		/* Copy data to temp arrays L[] and R[] */
		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];

		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays back into arr[l..r] */
		i = 0;
		j = 0;
		k = l;
		int c = 0;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				// increment inversion count of L[i]

				hm.put(L[i], (hm.get(L[i]) == null ? 0 : hm.get(L[i])) + c);
				arr[k++] = L[i++];
			} else {
				arr[k++] = R[j++];

				// inversion found
				c++;
			}
		}

		/*
		 * Copy the remaining elements of L[], if there are any
		 */
		while (i < n1) {
			hm.put(L[i], (hm.get(L[i]) == null ? 0 : hm.get(L[i])) + c);
			arr[k++] = L[i++];
		}

		/*
		 * Copy the remaining elements of R[], if there are any
		 */
		while (j < n2)
			arr[k++] = R[j++];
	}

	/*
	 * l is for left index and r is right index of the sub-array of arr to be
	 * sorted
	 */
	static void mergeSort(int arr[], int l, int r, Map<Integer, Integer> hm) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(arr, l, m, hm);
			mergeSort(arr, m + 1, r, hm);
			merge(arr, l, m, r, hm);
		}
	}

	/* Function to print an array */
	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(" " + arr[i]);
		System.out.println("\n");
	}

	static void findSurpasser(int arr[], int n) {
		// To store inversion count for elements
		Map<Integer, Integer> hm = new HashMap<>();

		// To store copy of array
		int dup[] = new int[n];
		System.arraycopy(arr, 0, dup, 0, n);

		// Sort the copy and store inversion count
		// for each element.
		mergeSort(dup, 0, n - 1, hm);

		System.out.println("Surpasser Count of array is \n");
		for (int i = 0; i < n; i++)
			System.out.println((n - 1) - i - (hm.get(arr[i]) == null ? 0 : hm.get(arr[i])));
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		int arr[] = { 2, 7, 5, 3, 0, 8, 1 };
		int n = arr.length;
		System.out.println("Given array is \n");
		printArray(arr, n);

		findSurpasser(arr, n);

	}

}
