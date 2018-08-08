package com;

public class UglyNumbers {

	public static void main(String[] args) {
		System.out.println(findThe150UglyNumber());
	}

	private static int findThe150UglyNumber() {
		int count = 1, uglyNumber = 0;
		int arr[] = new int[150];
		arr[0] = 1;
		int uglyNum2 = 0, uglyNum3 = 0, uglyNum5 = 0;
		while (count < 150) {
			uglyNumber = min(arr[uglyNum2] * 2, arr[uglyNum3] * 3,
					arr[uglyNum5] * 5);
			if (uglyNumber == arr[uglyNum2] * 2) {
				uglyNum2 = uglyNum2 + 1;
			}
			if (uglyNumber == arr[uglyNum3] * 3) {
				uglyNum3 = uglyNum3 + 1;
			}
			if (uglyNumber == arr[uglyNum5] * 5) {
				uglyNum5 = uglyNum5 + 1;
			}
			
			arr[count] = uglyNumber;
			count++;
		}
		return uglyNumber;
	}

	/* Function to find minimum of 3 numbers */
	private static int min(int a, int b, int c) {
		if (a <= b) {
			if (a <= c)
				return a;
			else
				return c;
		}
		if (b <= c)
			return b;
		else
			return c;
	}
}
