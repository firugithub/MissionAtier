package questions;

import core.SingleListNode;

public class ReverseASingleLinkList {
	
	static SingleListNode head=null;
	public static void main(String[] args) {

		/*
		 * The constructed linked list is: 1->2->3->4->5
		 */
		push(head, 5);
		push(head, 4);
		push(head, 3);
		push(head, 2);
		push(head, 1);

		System.out.println("\n Linked list before reverse ");
		printList(head);

		reverse(head);

		System.out.println("\n Linked list after reverse ");
		printList(head);
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
	public static SingleListNode push(SingleListNode node, int i) {
		SingleListNode new_node = new SingleListNode();
		new_node.setData(i);
		new_node.setNext(node);
		head=new_node;
		return new_node;
	}

	private static void reverse(SingleListNode head) {
		SingleListNode prev = null;
		SingleListNode current = head;
		SingleListNode next;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		ReverseASingleLinkList.head = prev;
	}

	
}
