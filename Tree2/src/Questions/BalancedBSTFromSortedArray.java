package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class BalancedBSTFromSortedArray {
	static NewNode newNode = new NewNode();

	/*
	 * A function that constructs Balanced Binary Search Tree from a sorted
	 * array
	 */
	Node sortedArrayToBST(int arr[], int start, int end) {
		/* Base Case */
		if (start > end)
			return null;

		/* Get the middle element and make it root */
		int mid = (start + end) / 2;
		Node root = newNode.getNewNode(arr[mid]);

		/*
		 * Recursively construct the left subtree and make it left child of root
		 */
		root.leftChild = sortedArrayToBST(arr, start, mid - 1);

		/*
		 * Recursively construct the right subtree and make it right child of
		 * root
		 */
		root.rightChild = sortedArrayToBST(arr, mid + 1, end);

		return root;
	}
}
