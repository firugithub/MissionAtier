package Questions;

import java.util.Arrays;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class Imp_BinaryTree_To_BST_Conversion {

	static NewNode node = new NewNode();
	static int index = 0;

	public static void main(String[] args) {
		Node root = node.getNewNode(10);
		root.leftChild = node.getNewNode(30);
		root.rightChild = node.getNewNode(15);
		root.leftChild.leftChild = node.getNewNode(20);
		root.rightChild.rightChild = node.getNewNode(5);
		printInorder(root);
		// convert Binary Tree to BST
		root = binaryTreeToBST(root);

		System.out
				.println("Following is Inorder Traversal of the converted BST: \n");
		printInorder(root);
	}

	private static void printInorder(Node root) {
		if (root == null)
			return;

		/* first recur on left child */
		printInorder(root.leftChild);

		/* then print the data of node */
		System.out.println(root.key);

		/* now recur on right child */
		printInorder(root.rightChild);
	}

	private static Node binaryTreeToBST(Node root) {

		if (root == null) {
			return null;
		}
		int size = getSize(root);
		int arr[] = new int[size];

		getInorderTraversalInArr(root, arr);

		Arrays.sort(arr);
		index = 0;
		return createByInorderTraversal(root, arr);
	}

	private static void getInorderTraversalInArr(Node node, int arr[]) {
		if (node == null) {
			return;
		}
		getInorderTraversalInArr(node.leftChild, arr);
		arr[index] = node.key;
		index++;
		getInorderTraversalInArr(node.rightChild, arr);
	}

	private static int getSize(Node root) {
		if (root == null) {
			return 0;
		}
		return (getSize(root.leftChild) + getSize(root.rightChild) + 1);
	}

	private static Node createByInorderTraversal(Node node, int arr[]) {
		if (node == null) {
			return null;
		}
		createByInorderTraversal(node.leftChild, arr);
		node.key = arr[index];
		index++;
		createByInorderTraversal(node.rightChild, arr);
		return node;
	}
}
