package Questions;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class ChildrenSumPropertu {
	static NewNode newNode = new NewNode();

	public static void main(String[] args) {
		Node root = newNode.getNewNode(10);
		root.leftChild = newNode.getNewNode(8);
		root.rightChild = newNode.getNewNode(2);
		root.leftChild.leftChild = newNode.getNewNode(3);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(1);
		root.rightChild.leftChild = newNode.getNewNode(1);
		System.out.println(checkChildrenSumProp(root));
	}

	private static boolean checkChildrenSumProp(Node root) {
		if (root == null)
			return false;
		Queue queue = new ArrayBlockingQueue(10);
		while (root != null) {
			int val = root.key;
			int sum = 0;
			if (root.leftChild != null) {
				sum = sum + root.leftChild.key;
				queue.add(root.leftChild);
			}
			if (root.rightChild != null) {
				sum = sum + root.rightChild.key;
				queue.add(root.rightChild);
			}

			if (val != sum
					&& (root.leftChild != null || root.rightChild != null)) {
				return false;
			} else {
				if (!queue.isEmpty()) {
					root = (Node) queue.remove();
				}
				else
				{
					return true;
				}

			}
		}
		return true;
	}

}
