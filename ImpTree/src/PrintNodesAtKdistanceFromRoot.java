public class PrintNodesAtKdistanceFromRoot {
	static NewNode newNode = new NewNode();

	public static void main(String args[]) {
		Node root = newNode.getNewNode(1);
		root.leftChild = newNode.getNewNode(2);
		root.rightChild = newNode.getNewNode(3);
		root.leftChild.leftChild = newNode.getNewNode(4);
		root.leftChild.rightChild = newNode.getNewNode(5);
		root.rightChild.rightChild = newNode.getNewNode(7);
		root.rightChild.leftChild = newNode.getNewNode(6);
		root.rightChild.leftChild.rightChild = newNode.getNewNode(8);

		printPaths(new int[256], 0, root, 1);
	}

	private static void printPaths(int[] arr, int pathLen, Node root, int k) {
		if (root == null) {
			return;
		}
		arr[pathLen] = root.key;
		if (root.leftChild == null && root.rightChild == null) {
			printArr(arr, pathLen, k);
		} else {
			pathLen++;
			printPaths(arr, pathLen, root.leftChild, k);
			printPaths(arr, pathLen, root.rightChild, k);
		}
	}

	private static void printArr(int[] arr, int pathlen, int k) {
		System.out.println(arr[pathlen - k]);
	}

}
