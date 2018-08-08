package BinaryTree;

public class NewNode {

	public Node node;

	public Node getNewNode(int data) {
		node = new Node(data);
		node.leftChild = null;
		node.rightChild = null;
		node.height=1;
		node.size=1;
		return node;

	}
	public Node getNewNode(char data) {
		node = new Node(data);
		node.leftChild = null;
		node.rightChild = null;
		node.height=1;
		node.size=1;
		return node;

	}

}
