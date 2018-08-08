package questions;

import core.SingleListNode;

public class PrintMiddleOfLinkedList {

	public static void main(String[] args) {
		System.out.println(getTheMiddleOfLinkedList(GetALinkedList.getList()).getData());

	}

	private static SingleListNode getTheMiddleOfLinkedList(SingleListNode head) {
		SingleListNode ptr1 = head, ptr2 = head;
		if (head == null)
			return null;
		int i = 0;
		while (ptr2.getNext() != null) {
			if (i == 0) {
				ptr2 = ptr2.getNext();
				i = 1;
			} else if (i == 1) {
				ptr1 = ptr1.getNext();
				ptr2 = ptr2.getNext();
				i = 0;
			}
		}

		return ptr1;
	}

}
