package Grab;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(5, 3));
		System.out.println(solution(3, 3));
		System.out.println(solution(1, 4));
		System.out.println(solution(0, 2));

	}

	public static String solution(int A, int B) {
		if (A >= B) {
			return helper("a", "b", B, A - B);
		}
		return helper("b", "a", A, B - A);
	}

	public static String helper(String a, String b, int count, int diff) {
		String res = "";
		for (int i = 0; i < count; i++) {
			if (diff > 0) {
				res += a + a + b;
				diff--;
			} else {
				res += a + b;
			}
		}

		for (int i = 0; i < diff; i++) {
			res += a;
		}

		return res;
	}
}
