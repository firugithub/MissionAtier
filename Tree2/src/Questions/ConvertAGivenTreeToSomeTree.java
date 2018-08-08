package Questions;

import BinaryTree.Node;

public class ConvertAGivenTreeToSomeTree {
	// Convert a given tree to a tree where every node contains sum of values of
	// nodes in left and right subtrees in the original tree
	int toSumTree(Node node) {
		// Base case
		if (node == null)
			return 0;

		// Store the old value
		int old_val = node.key;

		// Recursively call for left and right subtrees and store the sum as
		// new value of this node
		node.key = toSumTree(node.leftChild) + toSumTree(node.rightChild);

		// Return the sum of values of nodes in left and right subtrees and
		// old_value of this node
		return node.key + old_val;
	}
}
