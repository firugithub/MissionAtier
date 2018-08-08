package Questions;

import Traversals.InorderNonRecursiveTraversal;
import BinaryTree.NewNode;
import BinaryTree.Node;

public class TreetoHoldChildrenSumProperty {

	static NewNode newNode = new NewNode();

	public static void main(String[] args) {
		Node root = newNode.getNewNode(50);
		root.leftChild = newNode.getNewNode(7);
		root.rightChild = newNode.getNewNode(2);
		root.leftChild.leftChild = newNode.getNewNode(3);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(1);
		root.rightChild.leftChild = newNode.getNewNode(30);
	InorderNonRecursiveTraversal.inOrder(convertChildrenSumProp(root));
	}

	private static Node convertChildrenSumProp(Node root) {
		if (root == null || (root.leftChild == null && root.rightChild == null)) {
			return null;
		} else {
			convertChildrenSumProp(root.leftChild);
			convertChildrenSumProp(root.rightChild);
			int value = root.key;
			int sum = 0;
			if (root.leftChild != null) {
				sum = sum + root.leftChild.key;
			}
			if (root.rightChild != null) {
				sum = sum + root.rightChild.key;
			}
			if (sum > value) {
				root.key = value + sum - value;
				return root;
			} else if (value > sum) {
				int diff = value - sum;
				increment(root, diff);
			}
		}
		return root;
	}

	static void increment(Node node, int diff) {
		/* IF left child is not NULL then increment it */
		if (node.leftChild != null) {
			node.leftChild.key = node.leftChild.key + diff;

			// Recursively call to fix the descendants of node->left
			increment(node.leftChild, diff);
		} else if (node.rightChild != null) // Else increment right child
		{
			node.rightChild.key = node.rightChild.key + diff;

			// Recursively call to fix the descendants of node->right
			increment(node.rightChild, diff);
		}
	}
}
