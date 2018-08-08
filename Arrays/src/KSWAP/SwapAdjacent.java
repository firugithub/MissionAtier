package KSWAP;

/*
 * Given a large number N, convert it into a larger number as much as possible by swapping adjacent digits in the number.

You will be given a limit on the number of swaps that can be done, provide an algorithm that can convert it to the largest number possible with the limited swaps available.

Constraints: 0<=N<=1000000000000

Sample Input(Plaintext Link)
 2519372893
6
Sample Output(Plaintext Link)
 9532172893
Explanation
Original: 2519372893 Step 1: 2591372893 Step 2: 2951372893 Step 3: 9251372893 Step 4: 9521372893 Step 5: 9523172893 Step 6: 9532172893
 */
public class SwapAdjacent {
	static int nswaps = 0;

	static int findMax(int[] a, int start, int end) {
		int i = start;
		int index = 0;
		int max = 0;
		for (; i <= nswaps && i <= end; i++) {
			if (max < a[i]) {
				max = a[i];
				index = i;
			}
		}
		return index;
	}

	static void moveMaxElementToBeginning(int[] a, int maxIndx, int start) {
		int tmp;
		int i = 0;
		if (maxIndx == start)
			return;

		while (maxIndx != start && nswaps > 0) {
			tmp = a[maxIndx];
			a[maxIndx] = a[maxIndx - 1];
			a[maxIndx - 1] = tmp;
			maxIndx = maxIndx - 1;
			nswaps = nswaps - 1;
		}
		for (i = 0; i < 10; i++) {

		}
		// printf("%d ",a[i]);
		// printf("\n");
	}

	static void swapToMax(int[] a, int N) {

		int start = 0;
		int end = N - 1;
		int maxIndx;
		while (nswaps > 0) {
			maxIndx = findMax(a, start, end);
			// printf("found max %d indx %d\n",a[maxIndx],maxIndx);
			moveMaxElementToBeginning(a, maxIndx, start);
			// printf("moved max to front %d \n",a[0]);
			start = start + 1;

		}
	}

	public static void main(String args[]) {
		// your code goes here
		int i = 0;
		int a[] = { 2, 5, 1, 9, 3, 7, 2, 8, 9, 3 };

		nswaps = 6;
		swapToMax(a, 10); // 5 swaps

		for (i = 0; i < 10; i++) {
			System.out.print(a[i]);
		}
	}
}
