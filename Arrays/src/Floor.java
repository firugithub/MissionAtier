import java.util.Scanner;

public class Floor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {

			int n = sc.nextInt();
			double d = n;
			int m = (int) Math.floor(d);
			int arr[] = new int[n];
			for (int k = 0; k < n; k++) {
				arr[k] = k + 1;
			}

			if (findPartition(arr, n)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}

	}

	static boolean findPartition(int arr[], int n) {
		int sum = 0;
		int i, j;

		// Caculcate sun of all elements
		for (i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		boolean part[][] = new boolean[sum / 2 + 1][n + 1];

		// initialize top row as true
		for (i = 0; i <= n; i++)
			part[0][i] = true;

		// initialize leftmost column, except part[0][0], as 0
		for (i = 1; i <= sum / 2; i++)
			part[i][0] = false;

		// Fill the partition table in botton up manner
		for (i = 1; i <= sum / 2; i++) {
			for (j = 1; j <= n; j++) {
				part[i][j] = part[i][j - 1];
				if (i >= arr[j - 1])
					part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
			}
		}

		return part[sum / 2][n];
	}

}

// 
//         * Read input from stdin and provide input before running
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        int N = Integer.parseInt(line);
//        for (int i = 0; i < N; i++) {
//            System.out.println("hello world");
//        }
//        */
//
//        System.out.println("Hello World!");
//    }
//}

