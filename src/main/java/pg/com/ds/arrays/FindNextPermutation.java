package pg.com.ds.arrays;

/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Input: nums = [1,2,3]
Output: [1,3,2]

Input: nums = [3,2,1]
Output: [1,2,3]*/

public class FindNextPermutation {

	public static void main(String[] args) {
		

	}

	public static void  nextPermutation(int[] nums) {
		int n = nums.length;
		int i = n-2;
		//Step 1 : find index from where the number starts changing from first decreasing number from end
		while(i >= 0 && nums[i] <= nums[i+1]) {
			i--;
		}
		
		//Step 2 : find the number which will substitute step 1    
		if(i>0) {
			int j = n-1;
			// next highest after the number present at index i 
			while(j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			//Step 3: Swap numbers
			swap(nums, i, j);
		}
		
		//Step 4 : reverse the numbers after 
		reverse(nums, i+1);
	}

	private static void reverse(int[] nums, int i) {
		int start = i;
		int end = nums.length-1;
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
