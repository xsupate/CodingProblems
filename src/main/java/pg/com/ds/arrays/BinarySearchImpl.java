package pg.com.ds.arrays;

public class BinarySearchImpl {

	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,6,7};
		int target= 4;
		System.out.println("Index of " + target + " is " + binarySearch(nums, 0, nums.length-1, target));
	}

	public static int binarySearch(int[] nums, int start, int end, int target) {
		if(start <= end) {
			int mid = start + (end-start)/2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid]< target) {
				return binarySearch(nums, mid+1, end, target);
			}else {
				return binarySearch(nums, start, mid-1, target);
			}
		}
		return -1;
	}
}
