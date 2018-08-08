package arraysnew;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

	static void mergeIntervals(Interval arr[], int n) {
		// Sort Intervals in decreasing order of
		// start time
		Arrays.sort(arr, new Comparator<Interval>() {

			@Override
			public int compare(Interval a, Interval b) {
				return (b.s + "").compareTo(a.s + "");
			}

		});

		int index = 0; // Stores index of last element
		// in output array (modified arr[])

		// Traverse all input Intervals
		for (int i = 0; i < n; i++) {
			// If this is not first Interval and overlaps
			// with the previous one
			if (index != 0 && arr[index - 1].s <= arr[i].e) {
				while (index != 0 && arr[index - 1].s <= arr[i].e) {
					// Merge previous and current Intervals
					arr[index - 1].e = Math.max(arr[index - 1].e, arr[i].e);
					arr[index - 1].s = Math.min(arr[index - 1].s, arr[i].s);
					index--;
				}
			} else // Doesn't overlap with previous, add to
					// solution
				arr[index] = arr[i];

			index++;
		}

		// Now arr[0..index-1] stores the merged Intervals
		System.out.println("\n The Merged Intervals are: ");
		for (int i = 0; i < index; i++)
			System.out.println("[" + arr[i].s + ", " + arr[i].e + "] ");
	}

	// Driver program
	public static void main(String args[]) {
		Interval arr[] = { new Interval(6, 8), new Interval(1, 9), new Interval(2, 4), new Interval(4, 7) };
		int n = arr.length;
		mergeIntervals(arr, n);
	}
}

// An Interval
class Interval {
	int s, e;

	public Interval(int i, int j) {
		this.s = i;
		this.e = j;
	}

};
