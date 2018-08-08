package com;

public class ReverseAnArray {
	/* Function to left rotate arr[] of size n by d */
	static void leftRotate(int arr[], int d, int n) {
		rvereseArray(arr, 0, d - 1);
		rvereseArray(arr, d, n - 1);
		rvereseArray(arr, 0, n - 1);
	}

	/* UTILITY FUNCTIONS */
	/* function to print an array */
	static void printArray(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++)
			System.out.println(arr[i]);
		System.out.println("\n ");
	}

	/* Function to reverse arr[] from index start to end */
	static void rvereseArray(int arr[], int start, int end) {
		int i;
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		leftRotate(arr, 2, 7);
		printArray(arr, 7);
	}

}// Time Complexity: O(n)
