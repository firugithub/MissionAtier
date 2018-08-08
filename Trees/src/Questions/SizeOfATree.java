package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class SizeOfATree {

	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(50);
		root.leftChild = newNode.getNewNode(25);
		root.rightChild = newNode.getNewNode(75);
		root.leftChild.leftChild = newNode.getNewNode(15);
		root.leftChild.rightChild = newNode.getNewNode(30);
		root.rightChild.rightChild = newNode.getNewNode(85);
		root.rightChild.leftChild = newNode.getNewNode(79);
		
		System.out.println(getSize(root));
	}

	private static int getSize(Node node) {
		if (node != null) {
			return (getSize(node.leftChild) + 1 + getSize(node.rightChild));
		}
		return 0;
	}

}
//time and space complexities = O(n)