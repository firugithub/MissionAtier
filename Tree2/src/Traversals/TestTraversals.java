package Traversals;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class TestTraversals {
	static int index = 0;

	// A utility function to store inorder traversal of tree rooted
	// with root in an array arr[]. Note that i is passed as reference
	static void storeInorder(Node root) {
		if (root == null) {
			System.out.print('$');
			return;
		}
		storeInorder(root.leftChild);
		System.out.print(root.data);
		storeInorder(root.rightChild);
	}

	// A utility function to store preorder traversal of tree rooted
	// with root in an array arr[]. Note that i is passed as reference
	static void storePreOrder(Node root) {
		if (root == null) {
			System.out.print('$');
			return;
		}
		System.out.print(root.data);
		storePreOrder(root.leftChild);
		storePreOrder(root.rightChild);
	}

	public static void main(String args[]) {
		NewNode newNode = new NewNode();
		Node T = newNode.getNewNode('a');
		T.leftChild = newNode.getNewNode('b');
		T.rightChild = newNode.getNewNode('d');
		T.leftChild.leftChild = newNode.getNewNode('c');
		T.rightChild.rightChild = newNode.getNewNode('e');

		Node S = newNode.getNewNode('a');
		S.leftChild = newNode.getNewNode('b');
		S.leftChild.leftChild = newNode.getNewNode('c');
		S.rightChild = newNode.getNewNode('d');
		storeInorder(T);
		System.out.println("\n");
		storePreOrder(T);
		System.out.println("\nfor s");
		storeInorder(S);
		System.out.println("\n");
		storePreOrder(S);

	}
}
