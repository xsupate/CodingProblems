package pg.com.dsa.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationSolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        permute(nums, 0, result);
        return new ArrayList<List<Integer>>(result);
    }

    private void permute(int[] nums, int st, Set<List<Integer>> result) {
        if (st == nums.length)
            result.add(arrayToList(nums));
        for (int i = st; i < nums.length; i++) {
            swap(nums, i, st);
            permute(nums, st + 1, result);
            swap(nums, i, st);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private List<Integer> arrayToList(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int n : nums)
            list.add(n);
        return list;
    }
}