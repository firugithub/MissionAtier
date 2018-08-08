package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class PrintRootAtKdistance {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(13);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(26);
		root.rightChild.leftChild = newNode.getNewNode(25);
		printKDistant(root, 2);
	}

	static void printKDistant(Node root, int k) {
		if (root == null)
			return;
		if (k == 0) {
			System.out.println(root.key);
			return;
		} else {
			printKDistant(root.leftChild, k - 1);
			printKDistant(root.rightChild, k - 1);
		}
	}

}
