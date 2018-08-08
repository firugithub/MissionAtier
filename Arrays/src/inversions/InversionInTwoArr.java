package inversions;

public class InversionInTwoArr {
	public static void main(String args[]) {
		int arr1[] = { 3, 1, 2, 4, 5 };
		int arr2[] = { 3, 2, 4, 1, 5 };
		System.out.println(" Number of inversions are  \n" + countInversions(arr1, arr2, 5));
	}

	public static int countInversions(int arr1[], int arr2[], int len) {
		int count = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr1[i] > arr2[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
