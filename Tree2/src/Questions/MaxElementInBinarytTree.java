package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class MaxElementInBinarytTree {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(13);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(26);
		root.rightChild.leftChild = newNode.getNewNode(25);
		System.out.println(findMax(root));
	}

	private static int findMax(Node root) {
		int max = 0;
		int rootval, left, right;
		if (root != null) {
			rootval = root.key;
			left = findMax(root.leftChild);
			right = findMax(root.rightChild);

			if (left < right) {
				max = right;
			} else {
				max = left;
			}
			if (rootval > max) {
				max = rootval;
			}
		}
		return max;

	}

}
