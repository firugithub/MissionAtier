package diameter;

/* Java program to determine if binary tree is 
height balanced or not */

/* A binary tree node has data, pointer to left child,
and a pointer to right child */
class Node {

	int data;
	Node left, right;

	Node(int d) {
		data = d;
		left = right = null;
	}
}

class Height {

	int height = 0;
}

class BinaryTree {

	Node root;

	/* Returns true if binary tree with root as root is height-balanced */
	boolean isBalanced(Node root, Height height) {
		/*
		 * l will be true if left subtree is balanced and r will be true if
		 * right subtree is balanced
		 */
		boolean l = false, r = false;
		Height lheight = new Height();
		Height rheight = new Height();

		/* If tree is empty then return true */
		if (root == null) {
			height.height = 0;
			return true;
		}

		/* Get the height of left and right sub trees */
		l = isBalanced(root.left, lheight);
		r = isBalanced(root.right, rheight);

		height.height = (lheight.height > rheight.height ? lheight.height : rheight.height) + 1;

		/*
		 * If difference between heights of left and right subtrees is more than
		 * 2 then this node is not balanced so return 0
		 */
		if ((lheight.height - rheight.height >= 2) || (rheight.height - lheight.height >= 2))
			return false;

		/*
		 * If this node is balanced and left and right subtrees are balanced
		 * then return true
		 */
		else
			return l && r;

	}

	/* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
	/* returns maximum of two integers */
	int max(int a, int b) {
		return (a >= b) ? a : b;
	}

	/*
	 * The function Compute the "height" of a tree. Height is the number of
	 * nodes along the longest path from the root node down to the farthest leaf
	 * node.
	 */
	int height(Node node) {
		/* base case tree is empty */
		if (node == null)
			return 0;

		/*
		 * If tree is not empty then height = 1 + max of left height and right
		 * heights
		 */
		return 1 + max(height(node.left), height(node.right));
	}

	public static void main(String args[]) {
		Height height = new Height();

		/*
		 * Constructed binary tree is 1 / \ 2 3 / \ / 4 5 6 / 7
		 */
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		// tree.root.right.right = new Node(6);
		tree.root.left.left.left = new Node(7);

		if (tree.isBalanced(tree.root, height))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
