package Grab;

public class Solution2 {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 3, 5, 6, 7 };
		int arr2[] = { 4, 5, 2, 3, 4 };
		int arr3[] = { 3, 4, 5, 4 };
		System.out.println(solution(arr));
		System.out.println(solution(arr2));
		System.out.println(solution(arr3));

		System.out.println(solution(new int[] { 1, 2, 3 }));
		System.out.println(solution(new int[] { 3, 4, 5, 4 }));
		System.out.println(solution(new int[] { 4, 5, 2, 3, 4 }));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 5, 6, 7 }));
		System.out.println(solution(new int[] { 5, 2, 3, 4 }));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 6 }));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 5 }));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 5, 5 }));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 5, 6 }));
		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 5, 6, 7, 8 }));

	}

	public static int solution(int[] arr) {
		int numOfWays = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				if (numOfWays != 0) {
					return 0;
				}
				if (i == 1 || arr[i - 2] <= arr[i]) {
					numOfWays++;
				}
				if ((i == arr.length - 1) || (arr[i - 1] <= arr[i + 1])) {
					numOfWays++;
				}
				if (numOfWays == 0) {
					return 0;
				}
			}
		}

		if (numOfWays == 0) {
			numOfWays = arr.length;
		}

		return numOfWays;

	}
}
