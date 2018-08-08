package com;

/*Implement the following function, FindSortedArrayRotation, which takes as 
 * its input an array of unique integers that has been sorted in ascending order, 
 * then rotated by an unknown amount X where 0 <= X <= (arrayLength - 1). An array rotation 
 * by amount X moves every element array[i] to array[(i + X) % arrayLength]. FindSortedArrayRotation 
 * discovers and returns X by examining the array.
 //Solution:
 This time you have to search for the rotation pivot. There is a subtle observation. 
 This problem is in fact the same as finding the minimum element’s index. If the middle element
 is greater than the right most element, then the pivot must be to the right; if it is not, the pivot must
 be to the left.
 */
public class FindSortedArrayRotation {
	int FindSortedArrayRotation(int A[], int N) {
		int L = 0;
		int R = N - 1;

		while (A[L] > A[R]) {
			int M = L + (R - L) / 2;
			if (A[M] > A[R])
				L = M + 1;
			else
				R = M;
		}
		return L;
	}
}
