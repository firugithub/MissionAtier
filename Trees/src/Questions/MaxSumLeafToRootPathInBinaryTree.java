package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class MaxSumLeafToRootPathInBinaryTree {
	static int max = 0;

	public static void main(String[] args) {
		NewNode newNode = new NewNode();
		Node root = newNode.getNewNode(10);
		root.leftChild = newNode.getNewNode(-2);
		root.rightChild = newNode.getNewNode(7);
		root.leftChild.leftChild = newNode.getNewNode(8);
		root.leftChild.rightChild = newNode.getNewNode(-4);
		maxSumLeafToRootPathInBinaryTree(root, 0, new int[10]);
		System.out.println(max);
	}

	private static void maxSumLeafToRootPathInBinaryTree(Node root, int i, int[] arr) {
		if (root == null) {
			return;
		}
		arr[i] = root.key;
		if (root.leftChild == null && root.rightChild == null) {
			checkMax(i, arr);
		} else {
			i++;
			maxSumLeafToRootPathInBinaryTree(root.leftChild, i, arr);
			maxSumLeafToRootPathInBinaryTree(root.rightChild, i, arr);
		}

	}

	private static void checkMax(int i, int[] arr) {
		int m = 0;
		for (int j = 0; j <= i; j++) {
			m = m + arr[j];
		}
		if (m > max) {
			max = m;
		}
	}

}
