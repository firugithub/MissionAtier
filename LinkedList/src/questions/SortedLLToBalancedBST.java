package questions;

import core.SingleListNode;

public class SortedLLToBalancedBST {
	static SingleListNode head;

	public static void main(String args[]) {
		head = GetALinkedList.getList();
		preOrder(sortedLLToBalancedBST(head, 7));
	}

	private static TNode sortedLLToBalancedBST(SingleListNode list, int n) {
		if (n <= 0)
			return null;
		/* Recursively construct the left subtree */
		TNode left = sortedLLToBalancedBST(head, n / 2);

		/*
		 * Allocate memory for root, and link the above constructed left subtree
		 * with root
		 */
		TNode root = new TNode();
		root.data = head.getData();
		root.left = left;

		/* Change head pointer of Linked List for parent recursive calls */
		head = head.getNext();

		/*
		 * Recursively construct the right subtree and link it with root The
		 * number of nodes in right subtree is total nodes - nodes in left
		 * subtree - 1 (for root) which is n-n/2-1
		 */
		root.right = sortedLLToBalancedBST(head, n - n / 2 - 1);

		return root;
	}

	static void preOrder(TNode node) {
		if (node == null)
			return;
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
}

class TNode {
	int data;
	TNode left;
	TNode right;
};
