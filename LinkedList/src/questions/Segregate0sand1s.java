package questions;

import core.SingleListNode;

public class Segregate0sand1s {
	static SingleListNode head = null;

	public static void main(String[] args) {

		/*
		 * The constructed linked list is: 1->2->3->4->5
		 */
		push(head, 28);
		push(head, 101);
		push(head, 11);
		push(head, 81);
		push(head, 24);
		push(head, 51);
		push(head, 41);
		push(head, 21);
		push(head, 2);
		push(head, 1);
		

		System.out.println("\n Linked list before segregation ");
		printList(head);

		segregate(head);

		System.out.println("\n Linked list after segregation ");
		printList(head);
	}

	private static void segregate(SingleListNode head2) {
		SingleListNode end = head2, current = head2, prev = null;

		if (head2 == null) {
			return;
		}

		while (end.getNext() != null) {
			end = end.getNext();
		}
		SingleListNode new_end = end;
		while (current.getData() % 2 != 0 && current != end) {
			new_end.setNext(current);
			current = current.getNext();
			new_end.getNext().setNext(null);
			new_end = new_end.getNext();
		}
		if (current.getData() % 2 == 0) {
			head = current;
			while (current != end) {
				if (current.getData() % 2 == 0) {
					prev = current;
					current = current.getNext();
				} else {
					prev.setNext(current.getNext());
					new_end.setNext(current);
					current.setNext(null);
					new_end = new_end.getNext();
					current = prev.getNext();
				}
			}
		} else {
			prev = current;
		}

		/*
		 * If there are more than 1 odd nodes and end of original list is odd
		 * then move this node to end to maintain same order of odd numbers in
		 * modified list
		 */
		if (new_end != end && (end.getData()) % 2 != 0) {
			prev.setNext(end.getNext());
			end.setNext(null);
			new_end.setNext(end);
		}
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
	public static void push(SingleListNode node, int i) {
		SingleListNode new_node = new SingleListNode();
		new_node.setData(i);
		new_node.setNext(node);
		head = new_node;
	}

}
