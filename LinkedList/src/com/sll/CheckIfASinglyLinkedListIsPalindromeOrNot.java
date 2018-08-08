package com.sll;

import core.SingleListNode;

public class CheckIfASinglyLinkedListIsPalindromeOrNot {
	public static void main(String args[]) {
		/* Start with the empty list */
		String str = "abdcdba";
		SingleListNode head = null;
		int i;
		char[] arr = str.toCharArray();
		for (i = 0; i < arr.length; i++) {
			head = push(head, arr[i]);
			printList(head);
			System.out.println("is palindrome:" + isPalindrome(head));
		}

	}

	private static boolean isPalindrome(SingleListNode node) {
		boolean flag = true;
		SingleListNode slow_ptr = null, prev_of_slow_ptr, fast_ptr, midnode = null;
		if (node != null && node.getNext() != null) {
			prev_of_slow_ptr = slow_ptr;
			slow_ptr = node;
			fast_ptr = node;

			while (fast_ptr != null && fast_ptr.getNext() != null) {
				fast_ptr = fast_ptr.getNext().getNext();
				prev_of_slow_ptr = slow_ptr;
				slow_ptr = slow_ptr.getNext();
			}
			if (fast_ptr != null) {
				midnode = slow_ptr;
				slow_ptr = slow_ptr.getNext();
			}
			prev_of_slow_ptr.setNext(null);
			System.out.println("\n");
			System.out.println("before reverse is:");
			printList(slow_ptr);
			slow_ptr = reverse(slow_ptr); // Reverse the second half
			System.out.println("after reverse is:");
			printList(slow_ptr);
			flag = compareLists(node, slow_ptr); // compare

			/* Construct the original list back */
			slow_ptr = reverse(slow_ptr); // Reverse the second half again
			if (midnode != null) // If there was a mid node (odd size case)
									// which
									// was not part of either first half or
									// second half.
			{
				prev_of_slow_ptr.setNext(midnode);
			} else {
				prev_of_slow_ptr.setNext(slow_ptr);
			}

		}
		return flag;
		// TODO Auto-generated method stub

	}

	private static SingleListNode reverse(SingleListNode slow_ptr) {
		SingleListNode prev = null;
		SingleListNode current = slow_ptr;
		SingleListNode next;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		slow_ptr = prev;
		return slow_ptr;
	}

	private static boolean compareLists(SingleListNode node,
			SingleListNode slow_ptr) {
		while (node != null && slow_ptr != null) {
			if (node.getValue() == slow_ptr.getValue()) {
				node = node.getNext();
				slow_ptr = slow_ptr.getNext();
			} else {
				return false;
			}
		}
		if (node == null && slow_ptr == null) {
			return true;
		}
		return false;
	}

	// A utility function to print a given linked list
	static void printList(SingleListNode ptr) {
		while (ptr != null) {
			System.out.print(ptr.getValue()+" ");
			ptr = ptr.getNext();
		}
	}
	/*
	 * Push a node to linked list. Note that this function changes the head
	 */
	public static SingleListNode push(SingleListNode node, char new_data) {
		SingleListNode new_node = new SingleListNode();
		new_node.setValue(new_data);
		new_node.setNext(node);
		return new_node;
	}
}
