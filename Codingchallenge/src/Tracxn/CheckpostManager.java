package Tracxn;

import java.util.Stack;

public class CheckpostManager {

	public static void main(String[] args) {
		int[] vehicleNumOrder = { 1, 2, 3, 4, 5 };
		int[] vehicleNumOrder2 = { 3, 4, 2, 1, 5 };
		int[] vehicleNumOrder3 = { 3, 5, 2, 1, 4 };
		int[] vehicleNumOrder4 = { 4, 2, 6, 3, 1, 5 };
		System.out.println(checkOrder(vehicleNumOrder));
		System.out.println(checkOrder(vehicleNumOrder2));
		System.out.println(checkOrder(vehicleNumOrder3));
		System.out.println(checkOrder(vehicleNumOrder4));

	}

	private static boolean checkOrder(int[] vehicleNumOrder) {
		int currentExpectedNum = 1;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = vehicleNumOrder.length - 1; i >= 0; i--) {
			if (vehicleNumOrder[i] != currentExpectedNum) {
				stack.push(vehicleNumOrder[i]);
			} else {
				currentExpectedNum++;
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() != currentExpectedNum) {
				return false;
			} else {
				stack.pop();
				currentExpectedNum++;
			}
		}
		return true;
	}

}
