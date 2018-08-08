package BinaryTree;

public class NewNode {

	public Node node;

	public Node getNewNode(int data) {
		node = new Node(data);
		node.leftChild = null;
		node.rightChild = null;
		return node;

	}

}
