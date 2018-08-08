package BinaryTree;

public class Node {
	public int key;
	public String name;
	public Node leftChild;
	public Node rightChild;

	public Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public Node(int key) {
		this.key = key;
	}

	public String tostring() {
		return name + " has a key " + key;
	}

}
