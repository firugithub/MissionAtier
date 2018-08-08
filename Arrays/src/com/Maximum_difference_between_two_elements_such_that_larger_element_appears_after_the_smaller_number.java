package com;

public class Maximum_difference_between_two_elements_such_that_larger_element_appears_after_the_smaller_number {
	/*
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing
	 * order. Returns 0 if elements are equal
	 */
	public static void main(String[] args) {
		int arr[] = { 2, 3, 10, 6, 4, 8, 1 };
		int size = arr.length;
		System.out.println("Maximum difference is " + maxDiff(arr, size));
	}

	private static int maxDiff(int[] arr, int size) {
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for (i = 1; i < size; i++) {
			if (arr[i] - min_element > max_diff)
				max_diff = arr[i] - min_element;
			if (arr[i] < min_element)
				min_element = arr[i];
		}
		return max_diff;
	}

}
