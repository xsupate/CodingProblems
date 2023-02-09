package pg.com.ds.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */	

public class SubarraySumEqualsK {

	public static void main(String[] args) {
      int[] nums = {1,1,1};
      int target = 2;
      System.out.println("Number of subarray whose sum " + target + " is : " + getCountOfSubArray(nums, target));
	}

	public static int getCountOfSubArray(int[] nums, int target) {
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> countMap = new HashMap<>();
		countMap.put(0, 1);
		for(int n : nums) {
			sum += n;
			if(countMap.containsKey(sum - target)) {
				count = count + countMap.get(sum - target);
			}
			countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
		}
		
		return count;
	}
	
	public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
		int sum = 0;
		Map<Integer, Integer> countMap = new HashMap<>();
		countMap.put(0, 1);
		for(int n : nums) {
			sum += n;
            int rem = sum%k;
            if(rem < 0){
                rem += k;
            }
			if(countMap.containsKey(rem)) {
				count = count + countMap.get(rem);
			}
			countMap.put(rem, countMap.getOrDefault(rem, 0) + 1);
		}
		
		return count;
    }
}
