package com.inordersuccessor;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class PopulateInorderSuccessor {

	public static void main(String[] args) {
		/*
		 * Constructed binary tree is 10 / \ 8 12 / 3
		 */

		NewNode newNode = new NewNode();
		Node root = newNode.getNewNode(10);
		root.leftChild = newNode.getNewNode(8);
		root.rightChild = newNode.getNewNode(12);
		root.leftChild.leftChild = newNode.getNewNode(3);

		// Populates nextRight pointer in all nodes
		populateNext(root);

		// Let us see the populated values
		Node ptr = root.leftChild.leftChild;
		while (ptr != null) {
			// -1 is printed if there is no successor
			System.out.println("Next of :" + ptr.key + "  is:"
					+ (ptr.next != null ? ptr.next.key : -1));
			ptr = ptr.next;
		}
	}
	static Node next = null;
	/*
	 * Set next of p and all descendents of p by traversing them in reverse
	 * Inorder
	 */
	static void populateNext(Node p) {
		// The first visited node will be the rightmost node
		// next of the rightmost node will be NULL
		

		if (p != null) {
			// First set the next pointer in right subtree
			populateNext(p.rightChild);

			// Set the next as previously visited node in reverse Inorder
			p.next = next;

			// Change the prev for subsequent node
			next = p;

			// Finally, set the next pointer in left subtree
			populateNext(p.leftChild);
		}
	}
}
