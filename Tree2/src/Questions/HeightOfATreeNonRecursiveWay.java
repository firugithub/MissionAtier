package Questions;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class HeightOfATreeNonRecursiveWay {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(13);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(26);
		root.rightChild.leftChild = newNode.getNewNode(25);
		System.out.println(heightOfATree(root));
	}

	public static int heightOfATree(Node root) {
		int level = 0;
		if (root == null)
			return 0;
		Queue queue = new ArrayBlockingQueue(8);
		queue.add(root);
		queue.add(getNullNode());
		while (queue.isEmpty() == false) {
			Node node = (Node) queue.remove();
			if (node.key == 0) {
				if (queue.isEmpty() == false) {
					queue.add(getNullNode());
				}
				level++;
			} else {
				if (node.leftChild != null) {
					queue.add(node.leftChild);
				}
				if (node.rightChild != null) {
					queue.add(node.rightChild);
				}

			}
		}
		return level;
	}

	private static Node getNullNode() {
		Node root = newNode.getNewNode(0);
		return root;

	}
}
