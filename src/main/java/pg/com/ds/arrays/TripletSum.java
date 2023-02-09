package pg.com.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,and j != k,  
 * and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */		
public class TripletSum {

	public static void main(String[] args) {
		int[] nums = {-3, 0, 1, 2, -1, 1, -2};
		threeSum(nums).forEach(s -> System.out.print(s));;

	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
        for(int i=0; i < nums.length-2; i++) {
        	if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
        		int low = i+1;
        		int end = nums.length-1;
        		int sum = 0-nums[i];
        		while(low<end) {
        			if(sum == nums[low]+nums[end]) {
        			  result.add(Arrays.asList(nums[i], nums[low], nums[end]));
        			  while(low < end && nums[low] == nums[low+1]) low++;
        			  while(low < end && nums[end] == nums[end-1]) end--;
        			  low++;
        			  end--;
        			}else if(sum < nums[low]+nums[end]) {
        				end--;
        			}else {
        				low++;
        			}
        		}
        	}
        }
        return result;
    }

}
