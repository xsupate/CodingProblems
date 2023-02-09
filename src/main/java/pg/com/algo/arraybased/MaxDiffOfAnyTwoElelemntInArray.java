package pg.com.algo.arraybased;

import java.util.stream.Stream;

/**
 * Find the maximum difference of two elements of array, such that maximum elements should come after smaller element.
 * 
 * This Approach we are using to maximize the profit of buy and sell stocks one time with the given prices array.
 * 
 * @author sunipate
 *
 */
public class MaxDiffOfAnyTwoElelemntInArray {

	public static void main(String[] args) {
        int[] prices = {1, 4, 5, 2, 4};
        System.out.println("Maximum profit is " + maxDiff(prices));
	}

	public static int maxDiff(int[] nums) {
		int maxDiff = 0;
		int min_so_far = nums[0];
		for(int i = 1;i< nums.length; i++) {
			if(min_so_far > nums[i]) {
				min_so_far = nums[1];
			}
			maxDiff = Math.max(maxDiff, nums[i]-min_so_far);
		}
		return maxDiff;
	}
}
