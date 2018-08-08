package com;

public class Segregate0and1InAnArrayByTraversingOnlyOnce {
	/*
	 * Maintain two indexes. Initialize first index left as 0 and second index
	 * right as n-1.
	 * 
	 * Do following while left < right a) Keep incrementing index left while
	 * there are 0s at it b) Keep decrementing index right while there are 1s at
	 * it c) If left < right then exchange arr[left] and arr[right]
	 */

	/* Function to put all 0s on left and all 1s on right */
	static void segregate0and1(int arr[], int size) {
		/* Initialize left and right indexes */
		int left = 0, right = size - 1;

		while (left < right) {
			/* Increment left index while we see 0 at left */
			while (arr[left] == 0 && left < right)
				left++;

			/* Decrement right index while we see 1 at right */
			while (arr[right] == 1 && left < right)
				right--;

			/*
			 * If left is smaller than right then there is a 1 at left and a 0
			 * at right. Exchange arr[left] and arr[right]
			 */
			if (left < right) {
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
	}

	// Time Complexity: O(n)
	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 1, 1, 1 };
		int arr_size = 6, i = 0;

		segregate0and1(arr, arr_size);

		System.out.println("array after segregation ");
		for (i = 0; i < 6; i++)
			System.out.println(arr[i]);
	}

}
