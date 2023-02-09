package pg.com.roughTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		map.putIfAbsent(-1, new ArrayList<>());
		map.putIfAbsent(2, new ArrayList<>());
		List<List<Integer>> result = new ArrayList<>();
        map.entrySet().forEach(s -> result.add(s.getValue()));
        map.keySet().iterator().next();
	}

}
