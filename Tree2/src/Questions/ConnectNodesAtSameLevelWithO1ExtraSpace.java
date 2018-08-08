package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class ConnectNodesAtSameLevelWithO1ExtraSpace {
	static NewNode newNode = new NewNode();

	public static void main(String[] args) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);

		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(5);

		root.leftChild.leftChild.leftChild = newNode.getNewNode(8);
		root.leftChild.leftChild.rightChild = newNode.getNewNode(9);

		root.rightChild.leftChild = newNode.getNewNode(6);
		root.rightChild.rightChild = newNode.getNewNode(7);
		root.rightChild.rightChild.leftChild = newNode.getNewNode(10);
		root.rightChild.rightChild.rightChild = newNode.getNewNode(11);

		// Populates nextRight pointer in all nodes
		connect(root);

		// Let us check the values of nextRight pointers
		System.out
				.println("Following are populated nextRight pointers in the tree and -1 is printed if there is no nextRight) \n");
		System.out.println("nextRight of " + root.key + " is:"
				+ (root.nextRight != null ? root.nextRight.key : -1));
		System.out
				.println("nextRight of" + root.leftChild.key + "is:"
						+ root.leftChild.nextRight != null ? root.leftChild.nextRight.key
						: -1);
		System.out
				.println("nextRight of " + root.rightChild.key + "is:"
						+ root.rightChild.nextRight != null ? root.rightChild.nextRight.key
						: -1);
		System.out
				.println("nextRight of" + root.leftChild.leftChild.key + "is:"
						+ root.leftChild.leftChild.nextRight != null ? root.leftChild.leftChild.nextRight.key
						: -1);
		System.out
				.println("nextRight of" + root.rightChild.rightChild.key
						+ "is:" + root.rightChild.rightChild.nextRight != null ? root.rightChild.rightChild.nextRight.key
						: -1);

	}

	private static void connect(Node root) {
		if (root == null)
			return;

		root.nextRight = null;
		while (root != null) {
			Node q = root;
			while (q != null) {
				// Set the nextRight pointer for p's left child
				if (q.leftChild != null) {
					// If q has right child, then right child is nextRight of
					// p and we also need to set nextRight of right child
					if (q.rightChild != null)
						q.leftChild.nextRight = q.rightChild;
					else
						q.leftChild.nextRight = getNextRight(q);
				}

				if (q.rightChild != null)
					q.rightChild.nextRight = getNextRight(q);

				// Set nextRight for other nodes in pre order fashion
				q = q.nextRight;
			}
			// start from the first node of next level
			if (root.leftChild != null)
				root = root.leftChild;
			else if (root.rightChild != null)
				root = root.rightChild;
			else
				root = getNextRight(root);
		}
	}

	private static Node getNextRight(Node node) {
		Node root = node.nextRight;
		while (root != null) {
			if (root.leftChild != null) {
				return root.leftChild;
			} else if (root.rightChild != null) {
				return root.rightChild;
			}
			root = root.nextRight;
		}
		return root;
	}
}
