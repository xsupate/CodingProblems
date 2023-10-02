package pg.com.algo.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {

	public static void main(String[] args) {
		int nums[] = {2,3};
		subsetSums(nums).forEach(s-> System.out.print(s + " ,"));
	}
	
	public static List<Integer> subsetSums(int nums[]){
		List<Integer> sums = new ArrayList<>();
		subsetSums(0, 0, nums, sums);
		Collections.sort(sums);
		return sums;
	}

	private static void subsetSums(int index, int sum, int[] nums, List<Integer> sums) {
		if(index == nums.length) {
			sums.add(sum);
			return;
		}
		
		subsetSums(index+1, sum+nums[index], nums, sums);
		
		subsetSums(index+1, sum, nums, sums);
	}

}
