package arraysnew;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortElementsByFrequency {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
		int n = arr.length;
		Map<Integer, Integer> map = new LinkedHashMap<>();
		sortByFrequency(arr, n, map);
		System.out.println(map);
		Map<Integer, Integer> sortedMapAsc = sortByComparator(map);
		System.out.println(sortedMapAsc);
	}

	private static void sortByFrequency(int[] arr, int n, Map<Integer, Integer> map) {
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
	}

	public static Map<Integer, Integer> sortByComparator(Map<Integer, Integer> unsortMap) {

		List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(unsortMap.entrySet());

		Collections.sort(list, new MyComparator());

		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		for (Entry<Integer, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

}

class MyComparator implements Comparator<Entry<Integer, Integer>> {
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}
}
