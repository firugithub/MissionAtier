package questions;

import core.SingleListNode;

public class PairWiseSwapElementsOfAGivenLinkedList {

	static SingleListNode head;
	public static void main(String[] args) {

		/*
		 * The constructed linked list is: 1->2->3->4->5
		 */
		SingleListNode start = push(head, 5);
		push(head, 4);
		push(head, 3);
		push(head, 2);
		push(head, 1);

		System.out.println("\n Linked list before calling  pairWiseSwap() ");
		printList(head);

		pairWiseSwap(head);

		System.out.println("\n Linked list after calling  pairWiseSwap() ");
		printList(head);
	}

	private static void pairWiseSwap(SingleListNode temp) {
		SingleListNode start = temp;
		while (start != null && start.getNext() != null) {
			int store = start.getData();
			start.setData(start.getNext().getData());
			start.getNext().setData(store);
			start = start.getNext().getNext();
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
	public static SingleListNode push(SingleListNode node, int i) {
		SingleListNode new_node = new SingleListNode();
		new_node.setData(i);
		new_node.setNext(node);
		head=new_node;
		return new_node;
	}
}
