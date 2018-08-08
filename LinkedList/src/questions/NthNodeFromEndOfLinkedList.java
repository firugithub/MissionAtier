package questions;

import core.SingleListNode;

public class NthNodeFromEndOfLinkedList {
	public static void main(String args[]) {
		System.out.println(printNthNodeFromLast(GetALinkedList.getList(), 7)
				.getData());
	}

	private static SingleListNode printNthNodeFromLast(SingleListNode head,
			int i) {
		SingleListNode ptr1 = head, ptr2 = head;
		if (null != head) {

			int count = 0;
			while (count<i ) {
				ptr1 = ptr1.getNext();
				count++;
			}
			while (ptr1 != null) {
				ptr1 = ptr1.getNext();
				ptr2 = ptr2.getNext();
			}
			return ptr2;

		}
		return null;
	}

}
