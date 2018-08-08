package questions;

import core.SingleListNode;

public class DeleteALinkedList {

	public static void main(String[] args) {
		System.out.println(deleteALinkedList(GetALinkedList.getList()));

	}

	private static SingleListNode deleteALinkedList(SingleListNode head) {
		SingleListNode temp = null;
		while (null != head) {
			temp = head.getNext();
			head = null;
			head = temp;
		}
		return head;
	}

}
