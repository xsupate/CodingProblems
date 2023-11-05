package pg.com.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArray {

	public static void main(String[] args) {
		int nums[] = {1,2,3};
		permutations(nums).forEach(s -> System.out.println(s));
	}
	
	public static List<List<Integer>> permutations(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		permutations(0, nums, result);
		return result;
	}

	private static void permutations(int index, int[] nums, List<List<Integer>> result) {
		if(index == nums.length) {
			List<Integer> temp = new ArrayList<>();
			for(int num: nums)
				temp.add(num);
			result.add(temp);
		}
		
		for(int i = index; i < nums.length; i++) {
			// this below line is for duplicate array element and we wants unique permutations
			if(i > index && nums[i] == nums[i-1]) continue;
			swap(nums, index, i);
			permutations(index+1, nums, result);
			swap(nums, index, i);
		}
		
	}

	private static void swap(int[] nums, int index, int i) {
		int temp = nums[index];
		nums[index] = nums[i];
		nums[i] = temp;
	}

}
