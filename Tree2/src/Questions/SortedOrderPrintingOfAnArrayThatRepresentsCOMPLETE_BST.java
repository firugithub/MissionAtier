package Questions;

//In the above code, it is implemented that children of the node 'n' will be stored at 2n+1 & 2n+2
public class SortedOrderPrintingOfAnArrayThatRepresentsCOMPLETE_BST {
	static void printSorted(int arr[], int start, int end) {
		if (start > end)
			return;

		// print left subtree
		printSorted(arr, start * 2 + 1, end);

		// print root
		System.out.println(arr[start]);

		// print right subtree
		printSorted(arr, start * 2 + 2, end);
	}

	public static void main(String args[]) {
		int arr[] = { 4, 2, 5, 1, 3 };
		int arr_size = arr.length;
		printSorted(arr, 0, arr_size - 1);
	}
}
