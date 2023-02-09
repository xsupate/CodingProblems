package pg.com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency
of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given
input.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.*/

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		combinationSum(candidates,target).forEach(s -> System.out.println(s));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		
		combinationSum(candidates, 0 , target, new ArrayList<Integer>(), result);
		return result;
	}

	private static void combinationSum(int[] candidates, int start, int target, ArrayList<Integer> list, List<List<Integer>> result) {
		if(target < 0) {
			return;
		}else if(target == 0) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i= start; i < candidates.length; i++) {
			list.add(candidates[i]);
			combinationSum(candidates, i , target-candidates[i], list , result);
			list.remove(list.size()-1);
		}
	}
}
