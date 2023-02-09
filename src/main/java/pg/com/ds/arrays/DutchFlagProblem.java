package pg.com.ds.arrays;

public class DutchFlagProblem {

	public static void main(String[] args) {
		int[] flags = {2, 2, 0, 1, 2, 0};
		for(int num : sortDutchFlags(flags)) {
			System.out.print(num + " ");
		}
	}

	public static int[] sortDutchFlags(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		for(int i = 0; i <= end;) {
			if(nums[i] == 0) {
				swap(nums, i, start);
				start++;
				i++;
			}else if(nums[i] == 1) {
				i++;
			}else if(nums[i] == 2) {
				swap(nums, i, end);
				end--;
			}
		}
		return nums;
	}

	private static void swap(int[] nums, int i, int start) {
		int temp = nums[start];
		nums[start] = nums[i];
		nums[i] = temp;
	}
}
