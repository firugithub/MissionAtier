package Questions;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import BinaryTree.NewNode;
import BinaryTree.Node;
//recursive way -/* Helper function for getLevel().  It returns level of the data if data is
//present in tree, otherwise returns 0.*/
//int getLevelUtil(struct node *node, int data, int level)
//{
// if (node == NULL)
//     return 0;
//
// if (node->data == data)
//     return level;
//
// int downlevel = getLevelUtil(node->left, data, level+1);
// if (downlevel != 0)
//     return downlevel;
//
// downlevel = getLevelUtil(node->right, data, level+1);
// return downlevel;
//}

public class FindingLevelOfAnodeInaBinaryTree {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(13);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(25);
		root.rightChild.rightChild.rightChild = newNode.getNewNode(24);
		root.rightChild.leftChild = newNode.getNewNode(25);
		System.out.println(levelOfANode(root,
				root.rightChild.rightChild.rightChild));
	}

	public static int levelOfANode(Node root, Node find) {
		int level = 1;
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
			} else if (node.key == find.key) {
				return level;
			} else {
				if (node.leftChild != null) {
					queue.add(node.leftChild);
				}
				if (node.rightChild != null) {
					queue.add(node.rightChild);
				}

			}
		}
		return 0;
	}

	private static Node getNullNode() {
		Node root = newNode.getNewNode(0);
		return root;

	}
}
