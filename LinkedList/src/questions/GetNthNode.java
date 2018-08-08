package questions;

import core.SingleListNode;

public class GetNthNode {

	public static void main(String[] args) {
		System.out.println(getnthNodeofAList(GetALinkedList.getList(),14).getData());

	}

	private static SingleListNode getnthNodeofAList(SingleListNode list, int i) {
		
		if(list==null)
		{
			return null;
		}
		int length = LengthOftheLinkedList.getLengthOfLinkedList(list);
		if(i>length)
		{
			return null;
		}
		int count =1; 
		while(count<i)
		{
			list = list.getNext();
			count++;
		}
		return list;
	}
	

}
