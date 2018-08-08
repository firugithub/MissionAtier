package com;

public class ProductArrayPuzzle {

	public static void main(String[] args) {
		int[] arr = {10,3,5,6,2 };
		int prod_array[] = makeProductArray(arr, arr.length);
		for (int i : prod_array) {
			System.out.println(i);
		}
	}

	private static int[] makeProductArray(int[] arr, int length) {
		int left[] = new int[length];
		int right[] = new int[length];
		int prod[] = new int[length];

		left[0] = 1;
		right[length - 1] = 1;
		for (int i = 1; i < length; i++) {
			left[i] = arr[i - 1] * left[i - 1];
		}
		for (int i = length - 2; i >= 0; i--) {
			right[i] = arr[i + 1] * right[i + 1];
		}
		for (int i = 0; i < length; i++) {
			prod[i] = left[i] * right[i];
		}
		return prod;
	}

}
