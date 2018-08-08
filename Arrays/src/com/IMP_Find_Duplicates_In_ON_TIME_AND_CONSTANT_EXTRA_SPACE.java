package com;

public class IMP_Find_Duplicates_In_ON_TIME_AND_CONSTANT_EXTRA_SPACE {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
		printRepeating(arr);
	}

	private static void printRepeating(int[] arr) {
		int i;
		System.out.println("The repeating elements are: \n");
		for (i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		}
	}

}
