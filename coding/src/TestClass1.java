
/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestClass1 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		try {
			int N = Integer.parseInt(line);
			if (N < 1 || N > 999) {
				System.out.println("Invalid Input");
			} else {
				int kohlisRank[] = new int[N];
				int dhonisRank[] = new int[N];
				String[] line2 = br.readLine().trim().split(" ");
				String[] line3 = br.readLine().trim().split(" ");
				int tempArr1[] = new int[kohlisRank.length + 1];
				int tempArr2[] = new int[dhonisRank.length + 1];
				if (line2.length != N || line3.length != N) {
					System.out.println("Invalid Input");
				} else {

					for (int i = 0; i < N; i++) {
						kohlisRank[i] = Integer.parseInt(line2[i]);
						dhonisRank[i] = Integer.parseInt(line3[i]);
					}
					for (int i = 0; i < kohlisRank.length; i++) {
						tempArr1[kohlisRank[i]] = i + 1;
					}
					for (int i = 0; i < dhonisRank.length; i++) {
						tempArr2[i + 1] = tempArr1[dhonisRank[i]];
					}
					tempArr2 = Arrays.copyOfRange(tempArr2, 1, tempArr2.length);
					System.out.println(findCompatibility(tempArr2, N));
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid Input");
		}

	}

	public static int findCompatibility(int arr1[], int noOfMovies) {
		int temp[] = new int[noOfMovies];
		return mergeSort(arr1, temp, 0, noOfMovies - 1);
	}

	private static int mergeSort(int[] arr1, int[] temp, int low, int high) {
		int middle, compatibilityDiff = 0;
		if (high > low) {
			middle = (high + low) / 2;

			compatibilityDiff = mergeSort(arr1, temp, low, middle);
			compatibilityDiff += mergeSort(arr1, temp, middle + 1, high);

			compatibilityDiff += merge(arr1, temp, low, middle + 1, high);
		}
		return compatibilityDiff;
	}

	private static int merge(int[] arr1, int[] temp, int low, int middle, int high) {
		int i, j, k;
		int compatibilityDiff = 0;

		i = low;
		j = middle;
		k = low;
		while ((i <= middle - 1) && (j <= high)) {
			if (arr1[i] <= arr1[j]) {
				temp[k++] = arr1[i++];
			} else {
				temp[k++] = arr1[j++];
				compatibilityDiff = compatibilityDiff + (middle - i);
			}
		}

		while (i <= middle - 1)
			temp[k++] = arr1[i++];

		while (j <= high)
			temp[k++] = arr1[j++];

		for (i = low; i <= high; i++)
			arr1[i] = temp[i];

		return compatibilityDiff;
	}
}
