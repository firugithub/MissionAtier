package com;

public class FindMajorityElement {
	/*
	 * METHOD 3 (Using Moore’s Voting Algorithm)
	 * 
	 * This is a two step process. 1. Get an element occurring most of the time
	 * in the array. This phase will make sure that if there is a majority
	 * element then it will return that only. 2. Check if the element obtained
	 * from above step is majority element.
	 * 
	 * 1. Finding a Candidate: The algorithm for first phase that works in O(n)
	 * is known as Moore’s Voting Algorithm. Basic idea of the algorithm is if
	 * we cancel out each occurrence of an element e with all the other elements
	 * that are different from e then e will exist till end if it is a majority
	 * element. Time Complexity: O(n) Auxiliary Space : O(1)
	 */

	static int findTheCandidate(int A[]) {
		int index = 0, count = 1, i;
		for (i = 1; i < A.length; i++) {
			if (A[index] == A[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				index = i;
				count = 1;
			}
		}
		return A[index];

	}

	/* Function to check if the candidate occurs more than n/2 times */
	static boolean isMajority(int a[], int size, int cand) {
		int i, count = 0;
		for (i = 0; i < size; i++)
			if (a[i] == cand)
				count++;
		if (count > size / 2)
			return true;
		else
			return false;
	}

	/* Driver function to test above functions */
	public static void main(String[] args) {
		int a[] = { 1, 3, 3, 1, 2 };
		int can = findTheCandidate(a);
		System.out.println(isMajority(a, a.length, can));
	}

}
