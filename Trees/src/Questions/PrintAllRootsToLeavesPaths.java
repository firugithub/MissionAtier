package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class PrintAllRootsToLeavesPaths {

	static int[] path = new int[256];
	static int pathlen;

	static private void printPaths(Node root, int[] path, int pathlen) {
		if (root != null) {
			path[pathlen] = root.key;
			pathlen++;

			if (root.leftChild == null && root.rightChild == null) {
				printArray(path, pathlen);
			} else {
				System.out.println("came from left:" + pathlen);
				printPaths(root.leftChild, path, pathlen);
				System.out.println("came from rght:" + pathlen);
				printPaths(root.rightChild, path, pathlen);
			}

		}
	}

	private static void printArray(int[] path, int pathlen) {
		for (int i = 0; i < pathlen; i++) {
			System.out.print(path[i]);
		}
		System.out.println();
	}

	public static void main(String args[]) {
		NewNode newNode = new NewNode();
		Node root = newNode.getNewNode(50);
		root.leftChild = newNode.getNewNode(25);
		root.rightChild = newNode.getNewNode(75);
		root.leftChild.leftChild = newNode.getNewNode(15);
		root.leftChild.rightChild = newNode.getNewNode(30);
		root.rightChild.rightChild = newNode.getNewNode(85);
		root.rightChild.leftChild = newNode.getNewNode(65);
		printPaths(root, path, 0);
	}
}
