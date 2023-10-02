package pg.com.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates
 * where the candidate numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * Example : Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
 */
public class CombinationSumII {

	public static void main(String[] args) {
      int candidates[] = {10,1,2,7,6,1,5}, target = 8;
      System.out.println("combinationSum2 : " + combinationSum2(candidates, target));
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(0, target, candidates, new ArrayList<>(), result);
        return result;
    }
    private static void combinationSum( int index, int target, int[] arr, List<Integer> list, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i]>target) break;

            list.add(arr[i]);
            combinationSum(i+1, target-arr[i], arr, list, result);
            list.remove(list.size()-1); 
        } 
    }
}
