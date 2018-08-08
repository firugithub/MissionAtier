package diameter;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class DiameterOfAtree {

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
		System.out.println(diameterOpt(root, new Diameter()));
	}

	private static int diameterOpt(Node root, Diameter wrapper) {
		if (root == null) {
			return 0; // diameter and height are 0
		}

		/* wrappers for heights of the left and right subtrees */
		Diameter lhWrapper = new Diameter();
		Diameter rhWrapper = new Diameter();

		/* get heights of left and right subtrees and their diameters */
		int leftDiameter = diameterOpt(root.leftChild, lhWrapper);
		int rightDiameter = diameterOpt(root.rightChild, rhWrapper);

		/* calculate root diameter */
		int rootDiameter = lhWrapper.getHeight() + rhWrapper.getHeight() + 1;

		/* calculate height of current node */
		wrapper.setHeight(Math.max(lhWrapper.getHeight(), rhWrapper.getHeight()) + 1);

		/* calculate the diameter */
		return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
	}

	/* returns maximum of two integers */
	static int max(int a, int b) {
		return (a >= b) ? a : b;
	}

}
