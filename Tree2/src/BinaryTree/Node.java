package BinaryTree;

public class Node {
	public int key;
	public String name;
	public Node leftChild;
	public Node rightChild;
	public int height;
	public int size;
	public Node nextRight;
	public Node next;
	public char data;

	public Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public Node(int key) {
		this.key = key;
	}
	public Node(char data) {
		this.data = data;
	}

	public String tostring() {
		return name + " has a key " + key;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (key != other.key)
			return false;
		return true;
	}

}
