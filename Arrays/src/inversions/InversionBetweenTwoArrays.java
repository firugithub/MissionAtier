package inversions;

import java.util.Arrays;

public class InversionBetweenTwoArrays {

	/*
	 * This function sorts the input array and returns the number of inversions
	 * in the array
	 */
	static int mergeMain(int arr[], int array_size) {
		int temp[] = new int[array_size];
		return mergeSort(arr, temp, 0, array_size - 1);
	}

	/*
	 * An auxiliary recursive function that sorts the input array and returns
	 * the number of inversions in the array.
	 */
	static int mergeSort(int arr[], int temp[], int left, int right) {
		int mid, inv_count = 0;
		if (right > left) {
			/*
			 * Divide the array into two parts and call _mergeSortAndCountInv()
			 * for each of the parts
			 */
			mid = (right + left) / 2;

			/*
			 * Inversion count will be sum of inversions in left-part,
			 * right-part and number of inversions in merging
			 */
			inv_count = mergeSort(arr, temp, left, mid);
			inv_count += mergeSort(arr, temp, mid + 1, right);

			/* Merge the two parts */
			inv_count += merge(arr, temp, left, mid + 1, right);
		}
		return inv_count;
	}

	/*
	 * This funt merges two sorted arrays and returns inversion count in the
	 * arrays.
	 */
	static int merge(int arr[], int temp[], int left, int mid, int right) {
		int i, j, k;
		int inv_count = 0;

		i = left; /* i is index for left subarray */
		j = mid; /* i is index for right subarray */
		k = left; /* i is index for resultant merged subarray */
		while ((i <= mid - 1) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];

				/*
				 * this is tricky -- see above explanation/diagram for merge()
				 */
				inv_count = inv_count + (mid - i);
			}
		}

		/*
		 * Copy the remaining elements of left subarray (if there are any) to
		 * temp
		 */
		while (i <= mid - 1)
			temp[k++] = arr[i++];

		/*
		 * Copy the remaining elements of right subarray (if there are any) to
		 * temp
		 */
		while (j <= right)
			temp[k++] = arr[j++];

		/* Copy back the merged elements to original array */
		for (i = left; i <= right; i++)
			arr[i] = temp[i];

		return inv_count;
	}

	/* Driver progra to test above functions */
	public static void main(String args[]) {
		int arr1[] = { 3,1,2,4,5 };
		int arr2[] = { 3,2,4,1,5};
		int temp2[]= new int[arr1.length+1];
		int temp3[]= new int[arr1.length+1];
		for(int i=0;i<arr1.length;i++)
		{
			temp2[arr1[i]]=i+1;
		}
		for(int i=0;i<arr2.length;i++)
		{
			temp3[i+1] =temp2[arr2[i]]; 
		}
		int []temp4=Arrays.copyOfRange(temp3, 1, temp3.length);
		System.out.println(" Number of inversions are  \n" + mergeMain(temp4, 5));
	}
}
