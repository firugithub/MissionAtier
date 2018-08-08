package Traversals;

import java.util.Stack;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class PostorderNonRecursiveTraversal {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(4);
		//root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(7);
		//root.rightChild.leftChild = newNode.getNewNode(6);
		postOrder(root);

	}

	public static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.leftChild;
			} else {
				if (stack.isEmpty()) {
					System.out.println("stack is empty");
					return;
				} else if (getTop(stack).rightChild == null) {
					root = (Node) stack.pop();
					System.out.println(root.tostring());
					if (getTop(stack).rightChild == root) {
						System.out.println(getTop(stack).tostring());
						root = stack.pop();

					}
				}

				if (stack.isEmpty() == false) {
					if (root == getTop(stack).rightChild) {
						System.out.println(getTop(stack).tostring());
						stack.pop();
						root = null;
					} else {
						root = getTop(stack).rightChild;

					}
				} else {
					root = null;
				}
			}
		}
	}

	private static Node getTop(Stack<Node> s) {
		Node node = (Node) s.peek();
		return node;
	}

}
