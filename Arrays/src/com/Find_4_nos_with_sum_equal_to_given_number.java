package com;

import java.util.Arrays;
/*
 * Time Complexity: O(n^3)
 */
public class Find_4_nos_with_sum_equal_to_given_number {

	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 10, 12};
	    int X = 21;
	    find4Numbers(A, A.length, X);
	}
	static /* A sorting based solution to print all combination of 4 elements in A[]
	   with sum equal to X */
	void find4Numbers(int A[], int n, int X)
	{
	    int l, r;
	 
	    // Sort the array in increasing order, using library
	    // function 
	    Arrays.sort(A);
	 
	    /* Now fix the first 2 elements one by one and find
	       the other two elements */
	    for (int i = 0; i < n - 3; i++)
	    {
	        for (int j = i+1; j < n - 2; j++)
	        {
	            // Initialize two variables as indexes of the first and last 
	            // elements in the remaining elements
	            l = j + 1;
	            r = n-1;
	 
	            // To find the remaining two elements, move the index 
	            // variables (l & r) toward each other.
	            while (l < r)
	            {
	                if( A[i] + A[j] + A[l] + A[r] == X)
	                {
	                   System.out.println(A[i]+","+ A[j]+","+
	                                           A[l]+","+ A[r]);
	                   l++; r--;
	                }
	                else if (A[i] + A[j] + A[l] + A[r] < X)
	                    l++;
	                else // A[i] + A[j] + A[l] + A[r] > X
	                    r--;
	            } // end of while
	        } // end of inner for loop
	    } // end of outer for loop
	}
	 
}
