package BST;

import BinaryTree.Node;

public class IsBST {

	public boolean isBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data <= min || root.data > max) {
			return false;
		}
		return isBST(root.leftChild, min, root.data) && isBST(root.rightChild, root.data, max);
	}

	// Root of the Binary Tree
	Node root;

	// To keep tract of previous node in Inorder Traversal
	Node prev;

	boolean isBST() {
		prev = null;
		return isBST2(root);
	}

	/*
	 * Returns true if given search tree is binary search tree (efficient
	 * version)
	 */
	boolean isBST2(Node node) {
		// traverse the tree in inorder fashion and
		// keep a track of previous node
		if (node != null) {
			if (!isBST(node.leftChild))
				return false;

			// allows only distinct values node
			if (prev != null && node.data <= prev.data)
				return false;
			prev = node;
			return isBST(node.rightChild);
		}
		return true;
	}

}
