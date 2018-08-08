package questions;

import core.SingleListNode;

public class VIMP_ReverseAlternateKNodesOfALinkedList {
	static SingleListNode head = null;

	public static void main(String[] args) {

		/*
		 * The constructed linked list is: 1->2->3->4->5
		 */
		push( 10);
		push( 9);
		push( 8);
		push( 7);
		push( 6);
		push( 5);
		push( 4);
		push( 3);
		push( 2);
		push( 1);

		System.out.println("\n Linked list before segregation ");
		printList(head);

		reverseAlternate(head, 2, true);

		System.out.println("\n Linked list after segregation ");
		printList(head);
	}

	private static SingleListNode reverseAlternate(SingleListNode head2, int i,
			boolean flag) {
		if (head2 == null) {
			return null;
		}
		SingleListNode prev = null, next, current = head2;
		int count = 0;
		while (current != null && count < i) {
			next = current.getNext();
			if (flag) {
				current.setNext(prev);
			}
			prev = current;
			current = next;
			count++;
		}
		/*
		 * 3) If b is true, then node is the kth node. So attach rest of the
		 * list after node. 4) After attaching, return the new head
		 */
		if (flag == true) {
			head2.setNext(reverseAlternate(current, i, false));
			return prev;
		}

		/*
		 * If b is not true, then attach rest of the list after prev. So attach
		 * rest of the list after prev
		 */
		else {
			prev.setNext(reverseAlternate(current, i, true));
			return head2;
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
	public static void push(int i) {
		SingleListNode new_node = new SingleListNode();
		new_node.setData(i);
		new_node.setNext(head);
		head = new_node;
	}

}
