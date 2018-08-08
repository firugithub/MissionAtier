package com;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class VIMP_Count_Smaller_Elements_On_Right_Side {

	static int count = 0;

	private static int getSize(Node node) {
		if (node == null) {
			return 0;
		}
		return node.size;
	}

	private static int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private static Node rightRotate(Node node) {
		Node temp = node.leftChild;
		Node temp2 = temp.rightChild;

		// do the rotation

		temp.rightChild = node;
		node.leftChild = temp2;

		node.size = (getSize(node.leftChild) + 1 + getSize(node.rightChild));
		temp.size = (getSize(temp.leftChild) + 1 + getSize(temp.rightChild));
		node.height = (max(getHeight(node.leftChild),
				getHeight(node.rightChild)) + 1);
		node.height = (max(getHeight(temp.leftChild),
				getHeight(temp.rightChild)) + 1);

		return temp;

	}

	private static Node leftRotate(Node node) {
		Node temp = node.rightChild;
		Node temp2 = temp.leftChild;

		// do the rotation

		temp.leftChild = node;
		node.rightChild = temp2;

		node.size = (getSize(node.leftChild) + 1 + getSize(node.rightChild));
		temp.size = (getSize(temp.leftChild) + 1 + getSize(temp.rightChild));
		node.height = (max(getHeight(node.leftChild),
				getHeight(node.rightChild)) + 1);
		node.height = (max(getHeight(temp.leftChild),
				getHeight(temp.rightChild)) + 1);

		return temp;

	}

	// Get Balance factor of node N
	private static int getBalance(Node node) {
		if (node == null)
			return 0;
		return getHeight(node.leftChild) - getHeight(node.rightChild);
	}

	// Inserts a new key to the tree rotted with node. Also, updates *count
	// to contain count of smaller elements for the new key
	private static Node insert(Node node, int key, int count) {
		/* 1. Perform the normal BST rotation */
		if (node == null) {
			return (new NewNode().getNewNode(key));
		}
		if (key < node.key)
			node.leftChild = insert(node.leftChild, key, count);
		else {
			node.rightChild = insert(node.rightChild, key, count);

			// UPDATE COUNT OF SMALLER ELEMENTS FOR KEY
			count = count + getSize(node.leftChild) + 1;
		}

		/* 2. Update height and size of this ancestor node */
		node.height = max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
		node.size = getSize(node.leftChild) + getSize(node.rightChild) + 1;

		/*
		 * 3. Get the balance factor of this ancestor node to check whether this
		 * node became unbalanced
		 */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there are 4 cases

		// Left Left Case
		if (balance > 1 && key < node.leftChild.key)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && key > node.rightChild.key)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && key > node.leftChild.key) {
			node.leftChild = leftRotate(node.leftChild);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.rightChild.key) {
			node.rightChild = rightRotate(node.rightChild);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		System.out.println("Count is:" + count);
		VIMP_Count_Smaller_Elements_On_Right_Side.count = count;
		return node;
	}

	// The following function updates the countSmaller array to contain count of
	// smaller elements on right side.
	static void constructLowerArray(int arr[], int countSmaller[], int n) {
		int i, j;
		Node root = null;

		// initialize all the counts in countSmaller array as 0
		for (i = 0; i < n; i++)
			countSmaller[i] = 0;

		// Starting from rightmost element, insert all elements one by one in
		// an AVL tree and get the count of smaller elements
		for (i = n - 1; i >= 0; i--) {
			System.out.println("Next key is:"+arr[i]);
			root = insert(root, arr[i], countSmaller[i]);
			countSmaller[i] = count;
		}
	}

	/* Utility function that prints out an array on a line */
	static void printArray(int arr[], int size) {
		int i;
		System.out.println("\n");
		for (i = 0; i < size; i++)
			System.out.println(arr[i]);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = { 10, 6, 15, 20, 30, 5, 7 };
		int n = arr.length;

		int low[] = new int[n];

		constructLowerArray(arr, low, n);

		System.out.println("Following is the constructed smaller count array");
		printArray(low, n);
	}
}