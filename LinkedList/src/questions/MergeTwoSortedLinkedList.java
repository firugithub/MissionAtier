package questions;

public class MergeTwoSortedLinkedList {
	static SingleListNode head1 = null;
	static SingleListNode head2 = null;

	public static void main(String[] args) {

		/*
		 * The constructed linked list is: 1->2->3->4->5
		 */

		head1 = push(null, 7);
		head1 = push(head1, 5);
		head1 = push(head1, 3);
		head1 = push(head1, 1);
		System.out.println("\n first Linked list ");
		printList(head1);
		head2 = push(null, 15);
		head2 = push(head2, 10);
		head2 = push(head2, 5);
		System.out.println("\n Second Linked list ");
		printList(head2);
		 head1 = mergeSortedLinkedListInOne(head1, head2);
	//	head1 = recursiveMerge(head1, head2);
		System.out.println("\n Linked list after merge ");
		printList(head1);
	//	printList(head2);
	}

	private static SingleListNode mergeSortedLinkedListInOne(SingleListNode head1, SingleListNode head2) {
		if (head1 != null && head2 != null) {
			SingleListNode current1 = head1, current2 = head2, temp, prev = null;
			while (current1 != null && current2 != null) {
				if (current1.getData() > current2.getData()) {
					head2 = current2.getNext();
					current2.setNext(current1);
					if (prev != null) {

						prev.setNext(current2);
					} else {
						head1 = current2;
						prev = head1;
					}

					current2 = head2;

				} else if (current1.getData() < current2.getData()) {
					prev = current1;
					current1 = current1.getNext();
				} else {
					head2 = current2.getNext();
					temp = current1.getNext();
					current2.setNext(temp);
					current1.setNext(current2);
					current1 = current2.getNext();
					prev = current2;
					//head1 = current2.getNext();
					current2 = head2;

					
					//current2 = head2;
				}
			}
			if (current1 == null && current2 != null) {
				prev.setNext(head2);
			}

		}
		return head1;
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
	public static SingleListNode push(SingleListNode head, int i) {
		SingleListNode new_node = new SingleListNode();
		new_node.setData(i);
		new_node.setNext(head);
		return new_node;
	}

	public static SingleListNode recursiveMerge(SingleListNode head1, SingleListNode head2) {
		SingleListNode current = null;
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		if (head1.getData() <= head2.getData()) {
			current = head1;
			current.setNext(recursiveMerge(head1.getNext(), head2));
		} else {
			current = head2;
			current.setNext(recursiveMerge(head1, head2.getNext()));
		}
		return current;

	}
}

class SingleListNode {

	private int data;
	private SingleListNode next;

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
}