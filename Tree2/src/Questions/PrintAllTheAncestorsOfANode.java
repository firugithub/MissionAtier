package Questions;

import java.io.ObjectInputStream.GetField;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class PrintAllTheAncestorsOfANode {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(7);
		root.rightChild.leftChild = newNode.getNewNode(6);
		root.leftChild.leftChild.leftChild = newNode.getNewNode(8);
		root.leftChild.leftChild.rightChild = newNode.getNewNode(9);
		root.leftChild.rightChild.leftChild = newNode.getNewNode(10);
		root.leftChild.rightChild.rightChild = newNode.getNewNode(11);
		root.rightChild.leftChild.rightChild = newNode.getNewNode(13);
		root.rightChild.leftChild.leftChild = newNode.getNewNode(12);
		root.rightChild.rightChild.rightChild = newNode.getNewNode(15);
		root.rightChild.rightChild.leftChild = newNode.getNewNode(14);
		Node abc = newNode.getNewNode(5);
		System.out.println(abc.leftChild);
		System.out.println(printAllTheAncestors(root, newNode.getNewNode(7)));
	}

	private static boolean printAllTheAncestors(Node root, Node node) {
		if (root == null) {
			return false;
		} else if (root.rightChild.equals(node) || root.leftChild.equals(node)
				|| printAllTheAncestors(root.leftChild, node)
				|| printAllTheAncestors(root.rightChild, node)) {
			System.out.println(root.key);
			return true;
		}
		return false;
	}

}
