package Traversals;

import BST.BinarySearchTree;
import BinaryTree.NewNode;
import BinaryTree.Node;

public class Preorder {

	public static void preorderTraversal(Node focusNode) {
		if (focusNode != null) {
			// Visit the currently focused on node

			System.out.println(focusNode.tostring());
			// Traverse the left node

			preorderTraversal(focusNode.leftChild);

			// Traverse the right node

			preorderTraversal(focusNode.rightChild);

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		bstTraversal();
		binaryTreeTraversal();
	}

	public static void bstTraversal() {
		BinarySearchTree theTree = new BinarySearchTree();

		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice President");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(85, "Salesman 1");

		preorderTraversal(theTree.root);
	}

	public static void binaryTreeTraversal() {
		NewNode newNode = new NewNode();
		Node root = newNode.getNewNode(50);
		root.leftChild = newNode.getNewNode(25);
		root.rightChild = newNode.getNewNode(75);
		root.leftChild.leftChild = newNode.getNewNode(15);
		root.leftChild.rightChild = newNode.getNewNode(30);
		root.rightChild.rightChild = newNode.getNewNode(85);

		preorderTraversal(root);

	}

}
