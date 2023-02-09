package pg.com.ds.arrays;

import java.util.Map;
import java.util.TreeMap;

/*
 * Given an integer array of even length arr, return true if it is possible to reorder arr such that
 * arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.
 * Input: arr = [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 */

public class CanReorderDoubledArray {

	public static void main(String[] args) {
		int[] arr = {4,-2,2,-4};
		System.out.println("can Reorder Doubled Array : " + canReorderDoubled(arr));
	}
	
	public static boolean canReorderDoubled(int[] arr) {
		//Using treemap to sort array elements
        Map<Integer, Integer> map = new TreeMap<>();
		for(int num : arr)
			map.put(num, map.getOrDefault(num, 0) + 1);
		
		for(int key : map.keySet()) {	
			if(map.get(key) == 0) continue;
			
			int target = key < 0 ? key/2 : key*2;
            
            if(key < 0 && key%2 != 0)
                return false;
			
			if(map.get(key) > map.getOrDefault(target, 0)) {
				return false;
			}
			
			map.put(target, map.getOrDefault(target, 0)-map.get(key));
		}
		
		return true;
    }

}
