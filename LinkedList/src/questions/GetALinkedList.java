package questions;

import core.SingleListNode;

public class GetALinkedList {

	public static SingleListNode getList() {
		SingleListNode node1 = new SingleListNode();
		SingleListNode node2 = new SingleListNode();
		SingleListNode node3 = new SingleListNode();
		SingleListNode node4 = new SingleListNode();
		SingleListNode node5 = new SingleListNode();
		SingleListNode node6 = new SingleListNode();
		SingleListNode node7 = new SingleListNode();
		node1.setData(1);
		node1.setNext(node2);
		node2.setData(2);
		node2.setNext(node3);
		node3.setData(3);
		node3.setNext(node4);
		node4.setData(4);
		node4.setNext(node5);
		node5.setData(5);
		node5.setNext(node6);
		node6.setData(6);
		node6.setNext(node7);
		node7.setData(7);
		node7.setNext(null);
		return node1;

	}
	
	public static void main(String args[])
	{
		SingleListNode node = getList();
		while(true)
		{
			System.out.println(node.getData());
			if (node.getNext()==null) {
				break;
			}
			node= node.getNext();
		}
	}

}
