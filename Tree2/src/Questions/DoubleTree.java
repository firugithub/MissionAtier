package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;
import Traversals.InorderNonRecursiveTraversal;

public class DoubleTree {

	static NewNode newNode = new NewNode();

	public static void main(String[] args) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		// root.leftChild.leftChild = newNode.getNewNode(3);
		// root.leftChild.rightChild = newNode.getNewNode(5);
		// root.rightChild.rightChild = newNode.getNewNode(1);
		// root.rightChild.leftChild = newNode.getNewNode(1);
		doubleTree(root);
		InorderNonRecursiveTraversal.inOrder(root);
	}

	private static void doubleTree(Node node) {
		Node oldLeft;

		if (node == null)
			return;

		/* do the subtrees */
		doubleTree(node.leftChild);
		doubleTree(node.rightChild);

		/* duplicate this node to its left */
		oldLeft = node.leftChild;
		node.leftChild = newNode.getNewNode(node.key);
		node.leftChild.leftChild = oldLeft;
	}
}
