package com;

public class IMPO_FindoutpivotpointAroundWhichSortedArrayIsRotated {

	public static void main(String[] args) {
		int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int arr2[] = {6, 1, 2, 3, 4, 5};
		System.out.println(findPivot(arr1, 0, arr1.length));
		System.out.println(findPivot(arr2, 0, arr2.length));

	}
	public static int findPivot(int arr[], int low, int high)
	{
	   // base cases
	   if (high < low)  return -1;
	   if (high == low) return low;
	 
	   int mid = (low + high)/2;   /*low + (high - low)/2;*/
	   if (mid < high && arr[mid] > arr[mid + 1])
	     return mid;
	   if (mid > low && arr[mid] < arr[mid - 1])
	     return (mid-1);
	   if (arr[low] >= arr[mid])
	     return findPivot(arr, low, mid-1);
	   else
	     return findPivot(arr, mid + 1, high);
	}
}
