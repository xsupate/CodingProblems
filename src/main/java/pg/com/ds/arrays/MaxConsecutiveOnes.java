package pg.com.ds.arrays;

/*
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number 
 * of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		int[] nums = {1,1,0,1,1,1,0,1,1,1,1,1};
		System.out.println("Max Consecutive Ones is " + findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
	       int maximum=0;
	    int i=0;
	    while(i<nums.length)
	    {
	        int conOnes=0;
	        while(i< nums.length && nums[i]==1)
	        {
	            conOnes++;
	            i++;
	        }
	        maximum=Math.max(maximum,conOnes);
	        i++;
	    }
	        return maximum;
	   }
}
