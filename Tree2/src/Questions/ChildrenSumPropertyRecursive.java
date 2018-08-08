package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class ChildrenSumPropertyRecursive {

	static NewNode newNode = new NewNode();

	public static void main(String[] args) {
		Node root = newNode.getNewNode(10);
		root.leftChild = newNode.getNewNode(8);
		root.rightChild = newNode.getNewNode(2);
		root.leftChild.leftChild = newNode.getNewNode(3);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(1);
		root.rightChild.leftChild = newNode.getNewNode(0);
		System.out.println(checkChildrenSumProp(root));
	}

	private static boolean checkChildrenSumProp(Node root) {
		if (root == null || (root.leftChild == null && root.rightChild == null)) {
			return true;
		}
		int value = root.key;
		int sum = 0;
		if (root.leftChild != null) {
			sum = sum + root.leftChild.key;
		}
		if (root.rightChild != null) {
			sum = sum + root.rightChild.key;
		}
		return ((sum == value) && checkChildrenSumProp(root.leftChild) && checkChildrenSumProp(root.rightChild));

	}

}
