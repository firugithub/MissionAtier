package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class CountNoOfLeafNodesInATree {

	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.leftChild.leftChild.leftChild = newNode.getNewNode(8);
		root.leftChild.leftChild.rightChild = newNode.getNewNode(9);
		root.leftChild.rightChild.leftChild = newNode.getNewNode(10);
		root.leftChild.rightChild.rightChild = newNode.getNewNode(11);

		root.rightChild = newNode.getNewNode(3);
		root.rightChild.rightChild = newNode.getNewNode(7);
		root.rightChild.leftChild = newNode.getNewNode(6);
		root.rightChild.leftChild.rightChild = newNode.getNewNode(13);
		root.rightChild.leftChild.leftChild = newNode.getNewNode(12);
		root.rightChild.rightChild.rightChild = newNode.getNewNode(15);
		root.rightChild.rightChild.leftChild = newNode.getNewNode(14);
		System.out.println(countLeafNodes(root));
	}

	private static int countLeafNodes(Node root) {
		int lCount = 0;
		int rCount = 0;
		if (root == null)
			return 0;
		if ((root.leftChild == null && root.rightChild == null))
			return 1;
		if (root.rightChild != null) {
			lCount = countLeafNodes(root.leftChild);
		}
		if (root.leftChild != null) {
			rCount = countLeafNodes(root.rightChild);
		}
		return lCount+rCount;
	}

}
