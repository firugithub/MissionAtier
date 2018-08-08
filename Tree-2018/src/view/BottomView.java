package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BottomView {
	private static void printBottomView(Node root, Map<Integer, Node> map, int hd, int level) {
		if (root == null) {
			return;
		}
		if (map.get(Integer.valueOf(hd)) == null) {
			root.level = level;
			map.put(Integer.valueOf(hd), root);
		} else if (map.get(Integer.valueOf(hd)).level < level) {
			map.put(Integer.valueOf(hd), root);
		}
		printBottomView(root.left, map, hd - 1, level + 1);
		printBottomView(root.right, map, hd + 1, level + 1);

	}

	private static void printTopView(Node root, Map<Integer, Node> map, int hd, int level) {
		if (root == null) {
			return;
		}
		if (map.get(Integer.valueOf(hd)) == null) {
			root.level = level;
			map.put(Integer.valueOf(hd), root);
		} else if (map.get(Integer.valueOf(hd)).level > level) {
			map.put(Integer.valueOf(hd), root);
		}
		printTopView(root.left, map, hd - 1, level + 1);
		printTopView(root.right, map, hd + 1, level + 1);

	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right.right = new Node(25);
		Map<Integer, Node> map = new HashMap<>();
		//printBottomView(root, map, 0, 0);
		for (Entry<Integer, Node> entry : map.entrySet()) {
			System.out.println(entry.getValue().key);
		}
		Map<Integer, Node> map2 = new HashMap<>();
		printTopView(root, map2, 0, 0);
		for (Entry<Integer, Node> entry : map2.entrySet()) {
			System.out.println(entry.getValue().key);
		}
	}

}

class Node {
	public Node(int key) {
		super();
		this.key = key;
	}

	int key;
	Node left;
	Node right;
	int level;
}