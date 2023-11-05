package pg.com.algo.recursion;

/*
 * Given an integer array nums that may contain duplicates, return all possible subsets(the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, nums.length, new ArrayList<>(), result);
        return result;
    }

    public void subset(int[] nums, int start, int size, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(current));

        for (int i = start; i < size; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                current.add(nums[i]);
                subset(nums, i+1, size, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
