package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class printBstKeysInTheGivenRange {
	static NewNode newNode = new NewNode();

	public static void main(String[] args) {
		Node root = newNode.getNewNode(10);
		root.leftChild = newNode.getNewNode(8);
		root.rightChild = newNode.getNewNode(20);
		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(9);
		root.rightChild.rightChild = newNode.getNewNode(22);
		root.rightChild.leftChild = newNode.getNewNode(21);
		Print(root, 5,30);
	}

	static void Print(Node root, int k1, int k2) {
		/* base case */
		if (null == root)
			return;

		/*
		 * Since the desired o/p is sorted, recurse for left subtree first If
		 * root.key is greater than k1, then only we can get o/p keys in left
		 * subtree
		 */
		if (k1 < root.key)
			Print(root.leftChild, k1, k2);

		/* if root's data lies in range, then prints root's data */
		if (k1 <= root.key && k2 >= root.key)
			System.out.println(root.key);

		/*
		 * If root.key is smaller than k2, then only we can get o/p keys in
		 * right subtree
		 */
		if (k2 > root.key)
			Print(root.rightChild, k1, k2);
	}
}
