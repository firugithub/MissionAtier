package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class SumTree {
	static NewNode newNode = new NewNode();

	public static void main(String[] args) {
		Node root = newNode.getNewNode(26);
		root.leftChild = newNode.getNewNode(10);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(6);
		root.rightChild.rightChild = newNode.getNewNode(3);
		System.out.println(isSumTree(root));
	}

	/*
	 * A utility function to get the sum of values in tree with root as root
	 */
	static int sum(Node root) {
		if (root == null)
			return 0;
		return sum(root.leftChild) + root.key + sum(root.rightChild);
	}

	/*
	 * returns 1 if sum property holds for the given node and both of its
	 * children
	 */
	static boolean isSumTree(Node node) {
		int ls, rs;

		/*
		 * If node is null or it's a leaf node then return true
		 */
		if (node == null || (node.leftChild == null && node.rightChild == null))
			return true;

		/* Get sum of nodes in left and right subtrees */
		ls = sum(node.leftChild);
		rs = sum(node.rightChild);

		/*
		 * if the node and both of its children satisfy the property return 1
		 * else 0
		 */
		if ((node.key == ls + rs) && isSumTree(node.leftChild)
				&& isSumTree(node.rightChild))
			return true;

		return false;
	}

}
