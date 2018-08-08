package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class InorderSuccessorInBST {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(20);
		root.leftChild = newNode.getNewNode(1);
		root.rightChild = newNode.getNewNode(24);

		root.leftChild.leftChild = newNode.getNewNode(0);
		root.leftChild.rightChild = newNode.getNewNode(15);
		root.rightChild.rightChild = newNode.getNewNode(25);
		root.rightChild.leftChild = newNode.getNewNode(23);

		// root.leftChild.leftChild.leftChild = newNode.getNewNode(8);
		// root.leftChild.leftChild.rightChild = newNode.getNewNode(9);
		// root.leftChild.rightChild.leftChild = newNode.getNewNode(10);
		root.leftChild.rightChild.rightChild = newNode.getNewNode(16);
		// root.rightChild.leftChild.rightChild = newNode.getNewNode(13);
		// root.rightChild.leftChild.leftChild = newNode.getNewNode(12);
		// root.rightChild.rightChild.rightChild = newNode.getNewNode(15);
		// root.rightChild.rightChild.leftChild = newNode.getNewNode(14);
		System.out.println(findTheInorderSuccessor(root,
				root.rightChild).key);
	}

	static Node findTheInorderSuccessor(Node root, Node node ) {

		if (root == null || node == null) {
			return null;
		}
		if (node.rightChild != null) {
			return findMin(node.rightChild);
		} else {
			Node successor = null;
			while (root != null) {
				if (node.key < root.key) {
					successor = root;
					root = root.leftChild;
				} else if (node.key > root.key) {
					root = root.rightChild;
				}
				else
					break;
			}
			return successor;

		}
	}

	private static Node findMin(Node node) {
		if (node == null)
			return null;
		else {

			while (node.leftChild != null) {
				node = node.leftChild;
			}
			return node;
		}
	}
}
