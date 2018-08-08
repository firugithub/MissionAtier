package Questions;

import java.util.HashMap;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class VerticalSumInAGivenBinaryTree {
	// A wrapper over VerticalSumUtil()
	private static void VerticalSum(Node root) {

		// base case
		if (root == null) {
			return;
		}

		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		// Calls the VerticalSumUtil() to store the vertical sum values in hM
		VerticalSumUtil(root, 0, hM);

		// Prints the values stored by VerticalSumUtil()
		if (hM != null) {
			System.out.println(hM.entrySet());
		}
	}

	// Traverses the tree in Inoorder form and builds a hashMap hM that
	// contains the vertical sum
	private static void VerticalSumUtil(Node root, int hD,
			HashMap<Integer, Integer> hM) {

		// base case
		if (root == null) {
			return;
		}

		// Store the values in hM for left subtree
		VerticalSumUtil(root.leftChild, hD - 1, hM);

		// Update vertical sum for hD of this node
		int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
		hM.put(hD, prevSum + root.key);

		// Store the values in hM for right subtree
		VerticalSumUtil(root.rightChild, hD + 1, hM);
	}

	static NewNode newNode = new NewNode();

	// Driver class to test the verticalSum methods
	public static void main(String args[]) {

		/*
		 * Create following Binary Tree 1 / \ 2 3 / \ / \ 4 5 6 7
		 */
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.leftChild = newNode.getNewNode(6);
		root.rightChild.rightChild = newNode.getNewNode(7);

		System.out.println("Following are the values of vertical sums with "
				+ "the positions of the columns with respect to root ");
		VerticalSum(root);
	}
}

/*
 * Vertical Sum in a given Binary Tree Given a Binary Tree, find vertical sum of
 * the nodes that are in same vertical line. Print all sums through different
 * vertical lines.
 * 
 * Examples:
 * 
 * 1 / \ 2 3 / \ / \ 4 5 6 7 The tree has 5 vertical lines
 * 
 * Vertical-Line-1 has only one node 4 => vertical sum is 4 Vertical-Line-2: has
 * only one node 2=> vertical sum is 2 Vertical-Line-3: has three nodes: 1,5,6
 * => vertical sum is 1+5+6 = 12 Vertical-Line-4: has only one node 3 =>
 * vertical sum is 3 Vertical-Line-5: has only one node 7 => vertical sum is 7
 * 
 * So expected output is 4, 2, 12, 3 and 7
 * 
 * Solution: We need to check the Horizontal Distances from root for all nodes.
 * If two nodes have the same Horizontal Distance (HD), then they are on same
 * vertical line. The idea of HD is simple. HD for root is 0, a right edge (edge
 * connecting to right subtree) is considered as +1 horizontal distance and a
 * left edge is considered as -1 horizontal distance. For example, in the above
 * tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0 and HD
 * for node 7 is +2. We can do inorder traversal of the given Binary Tree. While
 * traversing the tree, we can recursively calculate HDs. We initially pass the
 * horizontal distance as 0 for root. For left subtree, we pass the Horizontal
 * Distance as Horizontal distance of root minus 1. For right subtree, we pass
 * the Horizontal Distance as Horizontal Distance of root plus 1.
 */