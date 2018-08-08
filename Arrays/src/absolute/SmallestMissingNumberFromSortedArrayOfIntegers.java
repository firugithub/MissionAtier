package absolute;

public class SmallestMissingNumberFromSortedArrayOfIntegers {
	int findFirstMissing(int array[], int start, int end) {
		if (start > end)
			return end + 1;

		if (start != array[start])
			return start;

		int mid = (start + end) / 2;

		if (array[mid] > mid)
			return findFirstMissing(array, start, mid);
		else
			return findFirstMissing(array, mid + 1, end);
	}

	// Driver program to test the above function
	public static void main(String[] args) {
		SmallestMissingNumberFromSortedArrayOfIntegers small = new SmallestMissingNumberFromSortedArrayOfIntegers();
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = arr.length;
		System.out.println("First Missing element is : " + small.findFirstMissing(arr, 0, n - 1));
	}
}
