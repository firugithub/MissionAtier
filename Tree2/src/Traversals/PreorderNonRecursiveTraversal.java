package Traversals;

import java.util.Stack;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class PreorderNonRecursiveTraversal {
	static NewNode newNode = new NewNode();

	public static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		Stack stack = new Stack();
		while (true) {
			while (root != null) {
				System.out.println(root.tostring());
				stack.push(root);
				root = root.leftChild;
			}
			if (stack.isEmpty() == true) {
				break;
			}
			Node node = (Node) stack.pop();
			root = node.rightChild;

		}
		return;
	}

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(7);
		root.rightChild.leftChild = newNode.getNewNode(6);
		preOrder(root);
	}

}
