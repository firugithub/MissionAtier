package com;

public class LeadersInAnArray {
	// Scan all the elements from right to left in array and keep track of
	// maximum till now. When maximum changes it’s value, print it.

	/* Function to print leaders in an array */
	static void printLeaders(int arr[], int size) {
		int max_from_right = arr[size - 1];
		int i;

		/* Rightmost element is always leader */
		System.out.println(max_from_right);

		for (i = size - 2; i >= 0; i--) {
			if (max_from_right < arr[i]) {
				System.out.println(arr[i]);
				max_from_right = arr[i];
			}
		}
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		printLeaders(arr, 6);
	}
}
