package absolute;

public class FindSmallestPositiveMissingNumberInAnArray {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 7, 6, 8, 15 };
		System.out.println(findMissingPositive(arr, 6));

	}

	/*
	 * Find the smallest positive missing number in an array that contains all
	 * positive integers
	 */
	public static int findMissingPositive(int arr[], int size) {
		int i;

		// Mark arr[i] as visited by making arr[arr[i] - 1] negative. Note that
		// 1 is subtracted because index start from 0 and positive numbers start
		// from 1
		for (i = 0; i < size; i++) {
			if (Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
		}

		// Return the first index value at which is positive
		for (i = 0; i < size; i++)
			if (arr[i] > 0)
				return i + 1; // 1 is added becuase indexes start from 0

		return size + 1;
	}

}
