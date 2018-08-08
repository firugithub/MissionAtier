import java.util.ArrayList;
import java.util.List;

public class GrayBitCode {

	public static void main(String args[]) {
		generateCode(2);
		System.out.println();
		generateCode(3);
	}

	public static void generateCode(int n) {
		if (n <= 0)
			return;
		List<String> arr = new ArrayList<String>();
		arr.add("0");
		arr.add("1");
		for (int i = 2; i <= n; ++i) {
			for (int j = (1 << i - 1) - 1; j >= 0; --j) {
				arr.add("1" + arr.get(j));
			}

			for (int j = 0; j < (1 << i - 1); ++j) {
				String ftr = "0" + arr.get(j);
				arr.remove(j);
				arr.add(j, ftr);
			}
			// System.out.println();
		}

		for (String st : arr)
			System.out.print(st + " ");
	}
}
