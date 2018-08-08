package Questions;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class TheMaxLevel {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);

		System.out.println(maxLevel(root));
	}

	private static int maxLevel(Node root) {
		int maxsum = 0, currentSum = 0, level = 0, maxLevel = 0;
		if (root == null)
			return 0;
		Queue queue = new LinkedBlockingQueue();
		queue.add(root);
		queue.add(getNullNode());
		while (queue.isEmpty() == false) {
			root = (Node) queue.remove();
			if (root.key == 0) {
				if (currentSum > maxsum) {
					maxsum = currentSum;
					maxLevel = level;
				}
				currentSum = 0;
				if (queue.isEmpty() == false) {

					queue.add(getNullNode());
				}
				level++;
			} else {
				currentSum = currentSum + root.key;
				if (root.rightChild != null) {
					queue.add(root.rightChild);
				}
				if (root.leftChild != null) {
					queue.add(root.leftChild);
				}

			}
		}
		System.out.println("maxLevel is:" + maxLevel);
		return maxsum;

	}

	private static Node getNullNode() {
		Node root = newNode.getNewNode(0);
		return root;

	}
}
