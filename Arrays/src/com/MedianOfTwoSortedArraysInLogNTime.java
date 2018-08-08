package com;

public class MedianOfTwoSortedArraysInLogNTime {
	public static int getMedianLogn(int[] arr1, int[] arr2, int start1, int end1, int start2, int end2) {
		int len = end1 - start1 + 1;
		if (len == 1)
			return (arr1[start1] + arr2[start2]) / 2;
		if (len == 2)
			return (Math.max(arr1[start1], arr2[start2]) + Math.min(arr1[end1], arr2[end2])) / 2;
		int m1 = calcMedian(arr1, start1, end1, len);
		int m2 = calcMedian(arr2, start2, end2, len);
		if (m1 == m2)
			return m1;
		if (m1 < m2) {
			if (len % 2 == 0)
				return getMedianLogn(arr1, arr2, start1 + (len / 2) - 1, end1, start2, end2 - (len / 2) + 1);
			return getMedianLogn(arr1, arr2, start1 + len / 2, end1, start2, end2 - len / 2);
		}
		if (len % 2 == 0)
			return getMedianLogn(arr1, arr2, start1, end1 - (len / 2) + 1, start2 + (len / 2) - 1, end2);
		return getMedianLogn(arr1, arr2, start1, end1 - len / 2, start2 + len / 2, end2);
	}

	public static int calcMedian(int[] arr, int start, int end, int len) {
		if (len % 2 == 0)
			return (arr[start + len / 2] + arr[start + len / 2 - 1]) / 2;
		return arr[start + len / 2];
	}

	public static void main(String args[]) {
		int ar1[] = { 1, 2, 3, 6 };
		int ar2[] = { 4, 6, 8, 10 };

		int ar3[] = { 1, 12, 15, 26, 38 };
		int ar4[] = { 2, 13, 17, 30, 45 };
		int n1 = ar1.length - 1;
		int n2 = ar2.length - 1;
		if (n1 == n2) {
			System.out.println("Median is:" + getMedianLogn(ar1, ar2, 0, n1, 0, n2));
			System.out.println("Median is:" + getMedianLogn(ar3, ar4, 0, 4, 0, 4));
		} else
			System.out.println("Doesn't work for arrays of unequal size");
	}
}
