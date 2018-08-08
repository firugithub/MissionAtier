package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class AllPathsFromRootToLeaves {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		// Node root = newNode.getNewNode(1);
		// root.leftChild = newNode.getNewNode(2);
		// root.rightChild = newNode.getNewNode(3);
		// root.leftChild.leftChild = newNode.getNewNode(4);
		// root.leftChild.rightChild = newNode.getNewNode(5);
		// root.rightChild.rightChild = newNode.getNewNode(7);
		// root.rightChild.leftChild = newNode.getNewNode(6);
		// root.leftChild.leftChild.leftChild = newNode.getNewNode(8);
		// root.leftChild.leftChild.rightChild = newNode.getNewNode(9);
		// root.leftChild.rightChild.leftChild = newNode.getNewNode(10);
		// root.leftChild.rightChild.rightChild = newNode.getNewNode(11);
		// root.rightChild.leftChild.rightChild = newNode.getNewNode(13);
		// root.rightChild.leftChild.leftChild = newNode.getNewNode(12);
		// root.rightChild.rightChild.rightChild = newNode.getNewNode(15);
		// root.rightChild.rightChild.leftChild = newNode.getNewNode(14);
		// printPaths(new int[256], 0, root);
		//

		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(7);
		root.rightChild.leftChild = newNode.getNewNode(6);
		root.leftChild.leftChild.leftChild = newNode.getNewNode(8);
		root.leftChild.leftChild.rightChild = newNode.getNewNode(9);
		root.leftChild.rightChild.leftChild = newNode.getNewNode(12);
		root.rightChild.rightChild.leftChild = newNode.getNewNode(10);
		root.rightChild.rightChild.leftChild.rightChild = newNode.getNewNode(11);
		root.leftChild.leftChild.rightChild.leftChild = newNode.getNewNode(13);
		root.leftChild.leftChild.rightChild.rightChild = newNode.getNewNode(14);
		root.leftChild.leftChild.rightChild.rightChild.leftChild = newNode.getNewNode(15);
		print(root);
		removeAllNodesThatLieOnAPathWithSumLessThanK(root,20);
		System.out.println();
		print(root);
	}

	private static void printPaths(int[] arr, int pathLen, Node root) {
		if (root == null) {
			return;
		}
		arr[pathLen] = root.key;
		if (root.leftChild == null && root.rightChild == null) {
			printArr(arr, pathLen);
		} else {
			pathLen++;
			printPaths(arr, pathLen, root.leftChild);
			printPaths(arr, pathLen, root.rightChild);
		}
	}

	private static void printArr(int[] arr, int pathlen) {
		for (int i = 0; i <= pathlen; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	private static Node removeAllNodesThatLieOnAPathWithSumLessThanK(Node root, int sum) {
		if (root == null) {
			return null;
		}
		root.leftChild = removeAllNodesThatLieOnAPathWithSumLessThanK(root.leftChild, sum - root.key);
		root.rightChild = removeAllNodesThatLieOnAPathWithSumLessThanK(root.rightChild, sum - root.key);

		if (root.leftChild == null && root.rightChild == null) {
			if (root.key < sum) {
				return null;
			}
		}
		return root;

	}

	private static boolean check(int[] arr, int pathlen) {
		int sum = 0;
		for (int i = 0; i <= pathlen; i++) {
			sum = sum + arr[i];
		}
		if (sum < 20) {
			return false;
		}
		return true;
	}

	static void print(Node root) {
		if (root != null) {
			print(root.leftChild);
			System.out.print(root.key + " ");
			print(root.rightChild);
		}
	}
}
