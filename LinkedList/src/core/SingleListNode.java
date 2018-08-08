package core;

public class SingleListNode {

	private int data;
	private SingleListNode next;
	private char value;

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SingleListNode getNext() {
		return next;
	}

	public void setNext(SingleListNode next) {
		this.next = next;
	}

	/*
	 * Push a node to linked list. Note that this function changes the head
	 */
	public SingleListNode push(SingleListNode node, char new_data) {
		SingleListNode new_node = new SingleListNode();
		new_node.setValue(new_data);
		new_node.setNext(null);
		if (node == null) {
			return new_node;
		}
		/* link the old list off the new node */
		node.setNext(new_node);

		/* move the head to pochar to the new node */

		return node;
	}

}
