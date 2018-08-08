package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;
import Traversals.InorderNonRecursiveTraversal;

public class ArraytoBST {
	
	static int index_ptr = 0;
	static void arrayToBST(int arr[], Node root) {
		// Base Case
		if (root == null)
			return;

		// first update the left subtree /
		arrayToBST(arr, root.leftChild);

		// Now update root's data and increment index /
		root.key = arr[index_ptr];
		index_ptr++;

		// finally update the right subtree /
		arrayToBST(arr, root.rightChild);
	}

	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		/*
		 * Constructing tree given in the above figure 10 / \ 30 15 / \ 20 5
		 */
		Node root = newNode.getNewNode(10);
		root.leftChild = newNode.getNewNode(30);
		root.rightChild = newNode.getNewNode(15);
		root.leftChild.leftChild = newNode.getNewNode(20);
		root.rightChild.rightChild = newNode.getNewNode(5);

		int[] arr = { 5, 10, 15, 20, 30 };
		// convert Binary Tree to BST
		arrayToBST(arr, root);

		InorderNonRecursiveTraversal.inOrder(root);

	}
}
