package pg.com.ds.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

https://www.youtube.com/watch?v=P6RZZMu_maU
*/
	
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		//int[] nums = {100,4,200,1,3,2};
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		System.out.println("length of Longest Consecutive Sequence " + longestConsSeq(nums));
	}
	
	public static int longestConsSeq(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		for(int num : nums)
			numSet.add(num);
		
		int maxLen = 0;
		for(int n : nums) {
			if(!numSet.contains(n-1)) {
				int length = 0;
				while(numSet.contains(n+length)) {
					length++;
				}
			    maxLen = Math.max(maxLen, length);
			}
		}
		return maxLen;
	}
}
