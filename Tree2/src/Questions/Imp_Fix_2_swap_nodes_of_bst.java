package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class Imp_Fix_2_swap_nodes_of_bst {
	// Initialize pointers needed for correctBSTUtil()
	static Node first, middle, last, prev;

	// A utility function to swap two integers
	static void swap(Node first, Node middle) {
		int t = first.key;
		first.key = middle.key;
		middle.key = t;
	}

	// This function does inorder traversal to find out the two swapped nodes.
	// It sets three pointers, first, middle and last. If the swapped nodes are
	// adjacent to each other, then first and middle contain the resultant nodes
	// Else, first and last contain the resultant nodes
	static void correctBSTUtil(Node root) {
		if (root != null) {
			// Recur for the left subtree
			correctBSTUtil(root.leftChild);

			// If this node is smaller than the previous node, it's violating
			// the BST rule.
			if (prev != null && root.key < (prev).key) {
				// If this is first violation, mark these two nodes as
				// 'first' and 'middle'
				if (first == null) {
					first = prev;
					middle = root;
				}

				// If this is second violation, mark this node as last
				else
					last = root;
			}

			// Mark this node as previous
			prev = root;

			// Recur for the right subtree
			correctBSTUtil(root.rightChild);
		}
	}

	// A function to fix a given BST where two nodes are swapped. This
	// function uses correctBSTUtil() to find out two nodes and swaps the
	// nodes to fix the BST
	static void correctBST(Node root) {
		// Set the poiters to find out two nodes
		correctBSTUtil(root);

		// Fix (or correct) the tree
		if (first != null && last != null)
			swap(first, last);
		else if (first != null && middle != null) // Adjacent nodes swapped
			swap(first, middle);

		// else nodes have not been swapped, passed tree is really BST.
	}

	// A utility function to print Inoder traversal /
	static void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.leftChild);
		System.out.println(node.key);
		printInorder(node.rightChild);
	}

	// Driver program to test above functions/
	public static void main(String args[]) {
		/*
		 * 6 / \ 10 2 / \ / \ 1 3 7 12 10 and 2 are swapped
		 */
		NewNode newNode = new NewNode();
		Node root = newNode.getNewNode(6);
		root.leftChild = newNode.getNewNode(10);
		root.rightChild = newNode.getNewNode(2);
		root.leftChild.leftChild = newNode.getNewNode(1);
		root.leftChild.rightChild = newNode.getNewNode(3);
		root.rightChild.rightChild = newNode.getNewNode(12);
		root.rightChild.leftChild = newNode.getNewNode(7);

		System.out.println("Inorder Traversal of the original tree \n");
		printInorder(root);

		correctBST(root);

		System.out.println("\nInorder Traversal of the fixed tree \n");
		printInorder(root);

	}
}