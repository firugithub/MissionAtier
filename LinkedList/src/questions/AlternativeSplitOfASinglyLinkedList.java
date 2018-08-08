package questions;

import core.SingleListNode;

public class AlternativeSplitOfASinglyLinkedList {
	static SingleListNode head = null;

	public static void main(String[] args) {

		/*
		 * The constructed linked list is: 1->2->3->4->5
		 */
		push(1);
		push(0);
		push(1);
		push(0);
		push(1);
		push(0);
		push(1);
		push(0);
		push(1);
		push(0);

		System.out.println("\n Linked list before segregation ");
		printList(head);

		SingleListNode head2 = alternateSplit(head);
		System.out.println("\n First Linked list after split ");
		printList(head);
		System.out.println("\n Second Linked list after split ");
		printList(head2);
	}

	private static SingleListNode alternateSplit(SingleListNode head2) {
		if (head2 == null) {
			return null;
		}
		SingleListNode second = null, current = head2, temp, tail = null;
		while (current != null) {
			temp = current.getNext();
			current.setNext(temp.getNext());
			temp.setNext(null);
			if (second == null && tail == null) {
				second = temp;
				tail = temp;
			}
			tail.setNext(temp);
			tail = tail.getNext();
			current = current.getNext();
		}
		return second;
	}

	// A utility function to print a given linked list
	static void printList(SingleListNode ptr) {
		while (ptr != null) {
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getNext();
		}
	}

	/*
	 * Push a node to linked list. Note that this function changes the head
	 */
	public static void push(int i) {
		SingleListNode new_node = new SingleListNode();
		new_node.setData(i);
		new_node.setNext(head);
		head = new_node;
	}

}
