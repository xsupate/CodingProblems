package pg.com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArrayElement {
List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
		int[] nums = {1,2,3};
		PermutationOfArrayElement obj = new PermutationOfArrayElement();
		obj.backtrack(nums, new ArrayList<>());
		obj.result.forEach(s -> System.out.print(" " + s));
	}
    
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> permutations ) {
        if(nums.length == permutations.size()) {
            result.add(new ArrayList<>(permutations));
            return ;
        }

        for(int i = 0; i < nums.length; i++) {   
           if(!permutations.contains(nums[i])) {
                permutations.add(nums[i]);
                backtrack(nums, permutations);
                permutations.remove(permutations.size()-1);
           }
        } 
    }
}
