package pg.com.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 * 
 * Input: nums = [1,1,2] Output: [[1,1,2], [1,2,1],[2,1,1]]
 *
 */
public class PermutationsOfArrayElemntsII {
	static Set<List<Integer>> resultSet = new HashSet<>();
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		permuteUnique(nums).stream().forEach(s -> System.out.print(s + " "));
		System.out.println();
		int[] nums1 = {1,2,3};
		permuteUnique(nums1).stream().forEach(s -> System.out.print(s + " "));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int n : nums)
			map.put(n, map.getOrDefault(n, 0) + 1);
		
		permuteUniqueHelper(map, new Integer[nums.length], 0, results);
		return results;
	}

	private static void permuteUniqueHelper(Map<Integer, Integer> map, Integer[] p,
			int i, List<List<Integer>> result) {
		if (i == p.length)
			result.add(Arrays.asList(Arrays.copyOf(p, p.length)));
		for (int key : map.keySet()) {
			if (map.get(key) > 0) {
				map.put(key, map.get(key) - 1);
				p[i] = key;
				permuteUniqueHelper(map, p, i + 1, result);
				map.put(key, map.get(key) + 1);
			}
		}
	}
	
    public static List<List<Integer>> permuteUnique1(int[] nums) {
        backtrack(nums, new LinkedHashMap<>());
        return new ArrayList<>(resultSet);
    }
    
    private static void backtrack(int[] nums, LinkedHashMap<Integer, Integer>currentMap) {
        if(nums.length == currentMap.size()) {
			//Set to avoid duplicate lists
            resultSet.add(new ArrayList<>(currentMap.values()));
            return;
        }
        
        for(int i = 0; i< nums.length; i++) { 
            if(!currentMap.containsKey(i)) {
                currentMap.put(i, nums[i]);
                backtrack(nums, currentMap);
                currentMap.remove(i);
            }    
        }  
    }
}
