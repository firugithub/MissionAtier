package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class AncestorsOfAnode {
	static NewNode newNode = new NewNode();

	public static void main(String[] args) {
		Node root = newNode.getNewNode(10);
		root.leftChild = newNode.getNewNode(8);
		root.rightChild = newNode.getNewNode(2);
		root.leftChild.leftChild = newNode.getNewNode(3);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(1);
		root.rightChild.leftChild = newNode.getNewNode(1);
		System.out.println(printAncestors(root,1));
	}

	/*
	 * If target is present in tree, then prints the ancestors and returns true,
	 * otherwise returns false.
	 */
	static boolean printAncestors(Node root, int target) {
		/* base cases */
		if (root == null)
			return false;

		if (root.key == target)
			return true;

		/*
		 * If target is present in either left or right subtree of this node,
		 * then print this node
		 */
		if (printAncestors(root.leftChild, target)
				|| printAncestors(root.rightChild, target)) {
			System.out.println(root.key);
			return true;
		}

		/* Else return false */
		return false;
	}
}
