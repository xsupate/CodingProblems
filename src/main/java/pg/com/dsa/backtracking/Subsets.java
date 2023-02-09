package pg.com.dsa.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1,2,2};
		Set<List<Integer>> res = new HashSet<>();
		List<Integer> curr = new ArrayList<>();
		generateAllSubsets(nums, 0, curr, res);
		new ArrayList<>(res).forEach(s-> System.out.println(s));
       // res.forEach(s-> System.out.println(s));
	}

	private static void generateAllSubsets(int[] nums, int i, List<Integer> curr, Set<List<Integer>> res) {
         if(i == nums.length) {
        	 res.add(new ArrayList<>(curr));
        	 return;
         }
         curr.add(nums[i]);
         generateAllSubsets(nums, i+1, curr, res);
         curr.remove(curr.size()-1);
         generateAllSubsets(nums, i+1, curr, res);
	}
	
	public static List<List<Integer>> findSubsets(int[] nums) {
	    List<List<Integer>> subsets = new ArrayList<>();
	    // start by adding the empty subset
	    subsets.add(new ArrayList<>());
	    for (int currentNumber : nums) {
	      // we will take all existing subsets and insert the current number in them to create new subsets
	      int n = subsets.size();
	      for (int i = 0; i < n; i++) {
	        // create a new subset from the existing subset and insert the current element to it
	        List<Integer> set = new ArrayList<>(subsets.get(i));
	        set.add(currentNumber);
	        subsets.add(set);
	      }
	    }
	    return subsets;
	  }

}
