package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class DiameterOfABinaryTreeNonRecursive {

	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(13);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.leftChild.rightChild.rightChild = newNode.getNewNode(5);

		root.rightChild.rightChild = newNode.getNewNode(26);
		root.rightChild.rightChild.rightChild = newNode.getNewNode(26);
		root.rightChild.rightChild.rightChild.leftChild = newNode
				.getNewNode(26);
		root.rightChild.rightChild.rightChild.leftChild.leftChild = newNode
				.getNewNode(26);

		root.rightChild.leftChild = newNode.getNewNode(25);
		System.out.println(diameter(root));
		System.out.println(diameterOpt(root, 0));
	}

	/* Function to get diameter of a binary tree */
	static int diameter(Node tree) {
		/* base case where tree is empty */
		if (tree == null)
			return 0;

		/* get the height of left and right sub-trees */
		int lheight = HeightOfATreeNonRecursiveWay
				.heightOfATree(tree.leftChild);
		int rheight = HeightOfATreeNonRecursiveWay
				.heightOfATree(tree.rightChild);

		/* get the diameter of left and right sub-trees */
		int ldiameter = diameter(tree.leftChild);
		int rdiameter = diameter(tree.rightChild);

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter
		 * of right subtree 3) Height of left subtree + height of right subtree
		 * + 1
		 */
		return max(lheight + rheight + 1, max(ldiameter, rdiameter));
	}

	/* returns maximum of two integers */
	static int max(int a, int b) {
		return (a >= b) ? a : b;
	}

	static int lh = 0, rh = 0;
	static int height=0;

	static int diameterOpt(Node root, int height) {
		/*
		 * lh --> Height of left subtree rh --> Height of right subtree
		 */

		lh = 0;
		rh = 0;
		/*
		 * ldiameter --> diameter of left subtree rdiameter --> Diameter of
		 * right subtree
		 */
		int ldiameter = 0, rdiameter = 0;

		if (root == null) {
			DiameterOfABinaryTreeNonRecursive.height=0;
			return 0; /* diameter is also 0 */
		}

		/*
		 * Get the heights of left and right subtrees in lh and rh And store the
		 * returned values in ldiameter and ldiameter
		 */
		ldiameter = diameterOpt(root.leftChild, lh);
		rdiameter = diameterOpt(root.rightChild, rh);

		/*
		 * Height of current node is max of heights of left and right subtrees
		 * plus 1
		 */
		DiameterOfABinaryTreeNonRecursive.height = max(lh, rh) + 1;

		return max(lh + rh + 1, max(ldiameter, rdiameter));
	}
}
