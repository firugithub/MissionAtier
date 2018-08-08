package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class FoldableTree {

	static NewNode newNode = new NewNode();

	public static void main(String[] args) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(3);
		// root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(1);
		// root.rightChild.leftChild = newNode.getNewNode(1);
		System.out.println(isFoldable(root));
	}

	static boolean isFoldable(Node root) {
		boolean res;

		/* base case */
		if (root == null)
			return true;

		/* convert left subtree to its mirror */
		mirror(root.leftChild);

		/*
		 * Compare the structures of the right subtree and mirrored left subtree
		 */
		res = isStructSame(root.leftChild, root.rightChild);

		/* Get the originial tree back */
		mirror(root.leftChild);

		return res;
	}

	static boolean isStructSame(Node a, Node b) {
		if (a == null && b == null) {
			return true;
		}
		if (a != null && b != null && isStructSame(a.leftChild, b.leftChild)
				&& isStructSame(a.rightChild, b.rightChild)) {
			return true;
		}

		return false;
	}

	/* UTILITY FUNCTIONS */
	/*
	 * Change a tree so that the roles of the left and right pointers are
	 * swapped at every node. See http://geeksforgeeks.org/?p=662 for details
	 */
	static void mirror(Node node) {
		if (node == null)
			return;
		else {
			Node temp;

			/* do the subtrees */
			mirror(node.leftChild);
			mirror(node.rightChild);

			/* swap the pointers in this node */
			temp = node.leftChild;
			node.leftChild = node.rightChild;
			node.rightChild = temp;
		}
	}

}
