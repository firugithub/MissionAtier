package Questions;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class FindingLeavesOfBinaryTree {

	private static void findLeaves(Node root) {
		Queue<Node> queue = new ArrayBlockingQueue<Node>(10);
		queue.add(root);
		while (true) {
			if (root != null) {
				if(queue.isEmpty())
				{
					break;
				}
				Node newNode = queue.remove();
				if (newNode.leftChild == null && newNode.rightChild == null) {
					System.out.println(newNode.key);
				} else {
					if (newNode.leftChild != null) {
						queue.add(newNode.leftChild);
					}
					if (newNode.rightChild != null) {
						queue.add(newNode.rightChild);
					}
				}
			}
		}
	}

	public static void main(String args[]) {
		NewNode newNode = new NewNode();
		Node root = newNode.getNewNode(50);
		root.leftChild = newNode.getNewNode(25);
		root.rightChild = newNode.getNewNode(75);
		root.leftChild.leftChild = newNode.getNewNode(15);
		root.leftChild.rightChild = newNode.getNewNode(30);
		root.rightChild.rightChild = newNode.getNewNode(85);
		root.rightChild.leftChild = newNode.getNewNode(65);
		findLeaves(root);
	}

}
