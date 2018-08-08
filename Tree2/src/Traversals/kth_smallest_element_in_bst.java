package Traversals;

import BinaryTree.NewNode;
import BinaryTree.Node;

public class kth_smallest_element_in_bst {

		static NewNode newNode = new NewNode();

		static int count=0;
		static int k=3;
		public static void main(String[] args) {
			/*
			 * Constructed binary tree is 1 / \ 2 3 / \ 4 5
			 */
			Node root = newNode.getNewNode(3);
			root.leftChild = newNode.getNewNode(2);
			root.rightChild = newNode.getNewNode(4);
			root.leftChild.leftChild = newNode.getNewNode(1);
			root.rightChild.rightChild = newNode.getNewNode(5);

			
			MorrisTraversal(root);
		}

		/*
		 * Function to traverse binary tree without recursion and without stack
		 */
		static void MorrisTraversal(Node root) {
			Node current, pre;

			if (root == null)
				return;

			current = root;
			while (current != null) {
			
				
				if (current.leftChild == null) {
					if(count>=k)
					{
						return;
					}
					System.out.println(current.key);
					count++;
					current = current.rightChild;
				} else {
					/* Find the inorder predecessor of current */
					pre = current.leftChild;
					while (pre.rightChild != null && pre.rightChild != current)
						pre = pre.rightChild;

					/* Make current as right child of its inorder predecessor */
					if (pre.rightChild == null) {
						pre.rightChild = current;
						current = current.leftChild;
					}

					/*
					 * Revert the changes made in if part to restore the original
					 * tree i.e., fix the right child of predecssor
					 */
					else {
						pre.rightChild = null;
						if(count>=k)
						{
							return;
						}
						System.out.println(current.key);
						count++;
						current = current.rightChild;
					} /* End of if condition pre.rightChild == null */
				} /* End of if condition current.leftChild == null */
				
			} /* End of while */
		}

	}
