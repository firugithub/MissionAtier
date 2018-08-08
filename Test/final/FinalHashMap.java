import java.util.HashMap;
import java.util.Iterator;

public class FinalHashMap {

	private final HashMap<String, String> map;

	// shallow copy constructor
	// public FinalHashMap(HashMap<String, String> map) {
	// super();
	// this.map = map;
	// }

	// deep copy constructor

	public FinalHashMap(HashMap<String, String> map) {
		super();
		HashMap<String, String> tempMap = new HashMap<String, String>();
		String key;
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			key = it.next();
			tempMap.put(key, map.get(key));
		}
		this.map = tempMap;
	}

	// shallow copy
	public HashMap<String, String> getMap() {
		return this.map;
	}

	// deep copy
	public HashMap<String, String> getMapDeepClone() {
		return (HashMap<String, String>) this.map.clone();
	}
}

class Test {
	public static void main(String args[]) {
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "1");
		map.put("ab", "12");
		FinalHashMap finalClass = new FinalHashMap(map);
		HashMap<String, String> map2 = finalClass.getMap();
		map2.put("asd", "asdsa");
		System.out.println(finalClass.getMap());

		HashMap<String, String> map3 = finalClass.getMapDeepClone();
		map3.put("asadsd", "asasdasddsa");
		System.out.println(finalClass.getMap());

	}
}
