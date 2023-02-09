package pg.com.ds.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		groupAnagrams(strs).forEach(s -> {
			s.forEach(t -> System.out.print(t + " "));
			System.out.println();
		});
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupAnagrams = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String newStr = new String(charArr);
            if(!map.containsKey(newStr))
                map.put(newStr, new ArrayList<String>());
            
            map.get(newStr).add(str);   
        }
        groupAnagrams.addAll(map.values());
        return groupAnagrams;
    }
}
