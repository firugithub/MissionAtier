import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public static <E> void main(String[] args) {
		int arr[] = { 1, 4, 7, 10, 13, 16 };
		int arr2[] = { 2, 5, 8, 11, 14, 17 };
		int arr3[] = { 3, 6, 9, 12, 15 };
		addKSortedArr(arr, arr2, arr3);

	}

	public static int[] addKSortedArr(int[] arr, int[] arr2, int[] arr3) {
		int len1 = arr.length;
		int len2 = arr2.length;
		int len3 = arr3.length;

		int finalArr[] = new int[len1 + len2 + len3];
		// Create a priority queue and insert all array elements
		// int
		PriorityQueue<Integer> pq = new PriorityQueue<>(3);
		pq.add(arr[0]);
		pq.add(arr2[0]);
		pq.add(arr3[0]);
		int i = 1, j = 1, k = 1, index = 0;
		while (i < len1 || j < len2 || k < len3) {
			int temp = pq.poll();
			finalArr[index++] = temp;
			if (temp == arr[i - 1]) {
				pq.add(arr[i]);
				i++;
			} else if (temp == arr2[j - 1]) {
				pq.add(arr2[j]);
				j++;
			} else {
				pq.add(arr3[k]);
				k++;
			}
		}
		for (int left : pq) {
			finalArr[index++] = left;
		}
		return finalArr;
	}

}
