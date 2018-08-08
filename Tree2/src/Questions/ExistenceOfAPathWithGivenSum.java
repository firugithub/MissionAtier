package Questions;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class ExistenceOfAPathWithGivenSum {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(7);
		root.rightChild.leftChild = newNode.getNewNode(6);
		root.leftChild.leftChild.leftChild = newNode.getNewNode(8);
		root.leftChild.leftChild.rightChild = newNode.getNewNode(9);
		root.leftChild.rightChild.leftChild = newNode.getNewNode(10);
		root.leftChild.rightChild.rightChild = newNode.getNewNode(11);
		root.rightChild.leftChild.rightChild = newNode.getNewNode(13);
		root.rightChild.leftChild.leftChild = newNode.getNewNode(12);
		root.rightChild.rightChild.rightChild = newNode.getNewNode(15);
		root.rightChild.rightChild.leftChild = newNode.getNewNode(14);
		System.out.println(checkPathWithReqSum(root, 26));
	}

	private static boolean checkPathWithReqSum(Node root, int i) {

		/* return true if we run out of tree and sum==0 */
		if (root == null) {
			return (i == 0);
		}

		else {
			boolean ans = false;

			/* otherwise check both subtrees */
			int subSum = i - root.key;

			/* If we reach a leaf node and sum becomes 0 then return true */
			if (subSum == 0 && root.leftChild == null
					&& root.rightChild == null)
				return true;

			if (root.leftChild != null)
				ans = ans || checkPathWithReqSum(root.leftChild, subSum);
			if (root.rightChild != null)
				ans = ans || checkPathWithReqSum(root.rightChild, subSum);

			return ans;
		}
	}
}
