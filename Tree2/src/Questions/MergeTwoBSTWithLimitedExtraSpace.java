package Questions;

import java.util.Stack;

import BinaryTree.NewNode;
import BinaryTree.Node;
import Traversals.InorderNonRecursiveTraversal;
//Merge two BSTs with limited extra space
//Given two Binary Search Trees(BST), print the elements of both BSTs in sorted form.
//The expected time complexity is O(m+n) where m is the number of nodes in first tree and
//n is the number of nodes in second tree. Maximum allowed auxiliary space is
//O(height of the first tree + height of the second tree).

public class MergeTwoBSTWithLimitedExtraSpace {

	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root1 = null, root2 = null;

		/*
		 * Let us create the following tree as first tree 3 / \ 1 5
		 */
		root1 = newNode.getNewNode(3);
		root1.leftChild = newNode.getNewNode(1);
		root1.rightChild = newNode.getNewNode(5);

		/*
		 * Let us create the following tree as second tree 4 / \ 2 6
		 */
		root2 = newNode.getNewNode(4);
		root2.leftChild = newNode.getNewNode(2);
		root2.rightChild = newNode.getNewNode(6);

		// Print sorted nodes of both trees
		merge(root1, root2);

	}

	// The function to print data of two BSTs in sorted order
	static void merge(Node root1, Node root2) {
		// s1 is stack to hold nodes of first BST
		Stack s1 = new Stack();

		// Current node of first BST
		Node current1 = root1;

		// s2 is stack to hold nodes of second BST
		Stack s2 = new Stack();

		// Current node of second BST
		Node current2 = root2;

		// If first BST is empty, then output is
		// InorderNonRecursiveTraversal.inOrder
		// traversal of second BST
		if (root1 == null) {
			InorderNonRecursiveTraversal.inOrder(root2);
			return;
		}
		// If second BST is empty, then output is
		// InorderNonRecursiveTraversal.inOrder
		// traversal of first BST
		if (root2 == null) {
			InorderNonRecursiveTraversal.inOrder(root1);
			return;
		}

		// Run the loop while there are nodes not yet printed.
		// The nodes may be in stack(explored, but not printed)
		// or may be not yet explored
		while (current1 != null || !s1.isEmpty() || current2 != null
				|| !s2.isEmpty()) {
			// Following steps follow iterative
			// inOrder Traversal
			if (current1 != null || current2 != null) {
				// Reach the leftmost node of both BSTs and push ancestors of
				// leftmost nodes to stack s1 and s2 respectively
				if (current1 != null) {
					s1.push(current1);
					current1 = current1.leftChild;
				}
				if (current2 != null) {
					s2.push(current2);
					current2 = current2.leftChild;
				}

			} else {
				// If we reach a null node and either of the stacks is empty,
				// then one tree is exhausted, ptint the other tree
				if (s1.isEmpty()) {
					while (!s2.isEmpty()) {
						current2 = (Node) s2.pop();
						current2.leftChild = null;
						InorderNonRecursiveTraversal.inOrder(current2);
					}
					return;
				}
				if (s2.isEmpty()) {
					while (!s1.isEmpty()) {
						current1 = (Node) s1.pop();
						current1.leftChild = null;
						InorderNonRecursiveTraversal.inOrder(current1);
					}
					return;
				}

				// Pop an element from both stacks and compare the
				// popped elements
				current1 = (Node) s1.pop();
				current2 = (Node) s2.pop();

				// If element of first tree is smaller, then print it
				// and push the right subtree. If the element is larger,
				// then we push it back to the corresponding stack.
				if (current1.key < current2.key) {
					System.out.println(current1.key);
					current1 = current1.rightChild;
					s2.push(current2);
					current2 = null;
				} else {
					System.out.println(current2.key);
					current2 = current2.rightChild;
					s1.push(current1);
					current1 = null;
				}
			}
		}
	}
}
