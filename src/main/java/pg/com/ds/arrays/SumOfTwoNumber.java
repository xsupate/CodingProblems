package pg.com.ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNumber {

	public static void main(String[] args) {
		int[] nums = {3,3};
		int target = 6;
		int[] rs = SumOfTwoNumber.twoSum(nums, target);
		for(int i : rs) {
			System.out.print(i + " ");
		}
	}

	public static int[] twoSum1(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexValueMap = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];
        	if(indexValueMap.containsKey(complement)) {
        	   return new int[]{indexValueMap.get(complement), index};	
        	}else{
               indexValueMap.put(nums[index],index); 
            }
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
}
