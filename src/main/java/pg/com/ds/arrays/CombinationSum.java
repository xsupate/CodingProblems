package pg.com.ds.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates 
 * where the chosen numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * 
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * 
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 */

public class CombinationSum {

	public static void main(String[] args) {
		int candidates[] = {2,3,5}, target = 8;
		combinationSum(candidates, target).forEach(s -> System.out.println(s));
        System.out.println("=================================");
        findAllCombinationSum(candidates, target).forEach(s -> System.out.println(s));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
		combinationSum(candidates, 0 , target, new ArrayList<Integer>(), result);
		return result;
	}
	
	
    // Recursive  + Iterative approach
	private static void combinationSum(int[] candidates, int i, int target, ArrayList<Integer> arrayList, List<List<Integer>> result) {
		if(target < 0) {
			return;
		}
		
		if(target == 0) {
			result.add(new ArrayList<Integer>(arrayList));
			return;
		}
		
		for(int start = i; start < candidates.length; start++ ) {
			arrayList.add(candidates[start]);
			combinationSum(candidates, start , target-candidates[start], arrayList, result);
			arrayList.remove(arrayList.size()-1);
		}
		
	}
	
	private static List<List<Integer>> findAllCombinationSum(int nums[], int sum){
		List<List<Integer>> result = new ArrayList<>();
		findAllCombinationSum(0,nums, sum, new ArrayList<Integer>(), result);
		return result;
	}

	// Pure Recursive approach 
	private static void findAllCombinationSum(int index, int[] nums, int target, ArrayList<Integer> list, List<List<Integer>> result) {
		if(index == nums.length) {
			if(target == 0) {
				result.add(new ArrayList<>(list));
			}
			return;
		}
		
		if(nums[index] <= target) {
			list.add(nums[index]);
			findAllCombinationSum(index, nums, target - nums[index], list, result);
			list.remove(list.size()-1);
		}
		
		findAllCombinationSum(index+1, nums, target, list, result);
	}
}
