package Traversals;

public class PrintPostorderFromInorderAndPreorder {

	static int globPreIndex = 0;

	public static void main(String[] args) {
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };
		printPostorder(in, pre, 0, in.length - 1);
	}

	private static void printPostorder(int[] in, int[] pre, int min, int max) {
		if (max < min)
			return;
		int root = pre[globPreIndex];
		globPreIndex = globPreIndex + 1;
		if (min < max) {
			int index = findIndex(root, in);
			printPostorder(in, pre, min, index - 1);
			printPostorder(in, pre, index + 1, max);

		}
		System.out.print(root + " ");

	}

	private static int findIndex(int root, int[] in) {
		for (int i = 0; i < in.length; i++)
			if (in[i] == root)
				return i;
		return -1;
	}
}