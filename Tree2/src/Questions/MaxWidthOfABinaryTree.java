package Questions;

// package Questions;
//
// import java.util.Queue;
// import java.util.concurrent.ArrayBlockingQueue;
//
// import BinaryTree.NewNode;
// import BinaryTree.Node;
//
// public class MaxWidthOfABinaryTree {
// static NewNode newNode = new NewNode();
//
// public static void main(String args[]) {
// Node root = newNode.getNewNode(1);
// root.leftChild = newNode.getNewNode(2);
// root.rightChild = newNode.getNewNode(3);
//
// root.leftChild.leftChild = newNode.getNewNode(4);
// root.leftChild.rightChild = newNode.getNewNode(5);
//
// root.rightChild.rightChild = newNode.getNewNode(8);
// root.rightChild.rightChild.leftChild = newNode.getNewNode(6);
// root.rightChild.rightChild.rightChild = newNode.getNewNode(7);
//
// System.out.println(heightOfATree(root));
//
// }
//
// public static int heightOfATree(Node root) {
// int level = 0;
// int noOfElementsInLevel = 0;
// if (root == null)
// return 0;
// Queue queue = new ArrayBlockingQueue(8);
// queue.add(root);
// queue.add(getNullNode());
// while (queue.isEmpty() == false) {
// Node node = (Node) queue.remove();
// if (node.key == 0) {
// if (queue.isEmpty() == false) {
// queue.add(getNullNode());
// }
// System.out.println("No. of elements in level:" + level
// + " is equal to:" + noOfElementsInLevel);
// noOfElementsInLevel = 0;
//
// level++;
// } else {
// noOfElementsInLevel++;
// if (node.leftChild != null) {
// queue.add(node.leftChild);
// }
// if (node.rightChild != null) {
// queue.add(node.rightChild);
// }
//
// }
//
//
// }
// return level;
// }
//
// private static Node getNullNode() {
// Node root = newNode.getNewNode(0);
// return root;
//
// }
// }
// Java program to calculate width of binary tree

/* A binary tree node has data, pointer to left child
   and a pointer to right child */
class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	Node root;

	/* Function to get the maximum width of a binary tree */
	int getMaxWidth(Node node) {
		int width;
		int h = height(node);

		// Create an array that will store count of nodes at each level
		int count[] = new int[10];

		int level = 0;

		// Fill the count array using preorder traversal
		getMaxWidthRecur(node, count, level);

		// Return the maximum value from count array
		return getMax(count, h);
	}

	// A function that fills count array with count of nodes at every
	// level of given binary tree
	void getMaxWidthRecur(Node node, int count[], int level) {
		if (node != null) {
			count[level]++;
			getMaxWidthRecur(node.left, count, level + 1);
			getMaxWidthRecur(node.right, count, level + 1);
		}
	}

	/* UTILITY FUNCTIONS */

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int height(Node node) {
		if (node == null)
			return 0;
		else {
			/* compute the height of each subtree */
			int lHeight = height(node.left);
			int rHeight = height(node.right);

			/* use the larger one */
			return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
		}
	}

	// Return the maximum value from count array
	int getMax(int arr[], int n) {
		int max = arr[0];
		int i;
		for (i = 0; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();

		/*
		 * Constructed bunary tree is: 1 / \ 2 3 / \ \ 4 5 8 / \ 6 7
		 */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(8);
		tree.root.right.right.left = new Node(6);
		tree.root.right.right.right = new Node(7);

		System.out.println("Maximum width is " + tree.getMaxWidth(tree.root));
	}
}

// This code has been contributed by Mayank Jaiswal