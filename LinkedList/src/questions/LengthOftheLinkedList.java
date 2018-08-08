package questions;

import core.SingleListNode;

public class LengthOftheLinkedList {

	public static void main(String args[]) {
		System.out.println(getLengthOfLinkedList(GetALinkedList.getList()));
	}

	public static int getLengthOfLinkedList(SingleListNode node) {
		int count = 0;

		if (null == node) {
			return count;
		}
		while (null != node) {
			count++;
			node = node.getNext();
		}
		return count;
	}
}
