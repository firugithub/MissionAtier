package com;

public class Find_the_Minimum_length_Unsorted_Subarray_sorting_which_makes_the_complete_array_sorted {

	static void printArray(int A[], int min, int max) {
		for (int i = min; i <= max; i++) {
			System.out.print(".." + A[i]);
		}
	}

	static void sortSubArr(int A[], int low, int high) {
		int min = low, max = high;
		for (int i = low; i < high; i++) {
			if (A[i + 1] < A[i]) {
				min = i;
				break;
			}
		}
		for (int i = high - 1; i > low; i--) {
			if (A[i] < A[i - 1]) {
				max = i;
				break;
			}
		}
int  localMin=A[min], localMax=A[min];
		for (int i = min; i <= max; i++) {
			if (A[i] > localMax)
				localMax = A[i];
			if (A[i] < localMin)
				localMin = A[i];
		}
		System.out.println("localmax:" + localMax + "....localMin" + localMin);
		for (int i = low; i < min; i++) {
			if (A[i] > localMin) {
				min = i;
			}
		}

		for (int i = high - 1; i > max; i--) {
			if (A[i] < localMax) {
				max = i;
			}
		}
		System.out.println("Array is between" + min + "...and " + max);
		printArray(A, min, max);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		sortSubArr(arr, 0, arr.length);
	}

}
