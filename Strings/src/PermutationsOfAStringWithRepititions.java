import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PermutationsOfAStringWithRepititions {
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		String line;
		String number = null;
		try {
			line = br.readLine();
			if (line != null && !line.isEmpty()) {
				N = Integer.parseInt(line);
			}

			number = br.readLine();
			if (line != null && !line.isEmpty()) {
				number = number.replace(" ", "");
				if (Integer.parseInt(String.valueOf(number.charAt(0))) != 1) {
					throw new Exception();
				}
				permute(number.toCharArray(), 0, N);
				System.out.println((list.indexOf(Integer.parseInt(number)) + 1) % 1000007);
			}
		} catch (Exception e) {

		}
	}

	private static void permute(char[] charArray, int i, int j) {
		char[] result = new char[charArray.length];
		permuteUtil(charArray, result, j - 1, i);

	}

	private static void permuteUtil(char[] charArray, char[] result, int last, int index) {
		for (int i = 0; i <= charArray.length - 1; i++) {
			result[index] = charArray[i];
			if (index == last) {
				if (checkValid(result, last + 1) && !(list.contains(Integer.parseInt(String.valueOf(result))))) {
					list.add(Integer.parseInt(String.valueOf(result)));
					System.out.println(String.valueOf(result));
				}

			} else {
				permuteUtil(charArray, result, last, index + 1);
			}
		}

	}

	private static boolean checkValid(char[] arr, int n) {
		boolean count[] = new boolean[n];
		boolean hasSeenFalse = false;
		if (Integer.parseInt(String.valueOf(arr[0])) != 1) {
			return false;
		}
		for (char ch : arr) {
			count[Integer.parseInt(String.valueOf(ch)) - 1] = true;
		}
		for (boolean flag : count) {
			if (flag) {
				if (hasSeenFalse) {
					return false;
				}
			} else {
				hasSeenFalse = true;
			}
		}
		return true;
	}
}
