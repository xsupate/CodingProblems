package pg.com.ds.arrays;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;

		int i = 0;
		for (i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] < nums[i])
				break;
		}

		int index = binarySearch(nums, 0, i, target);
		if (index == -1)
			index = binarySearch(nums, i + 1, nums.length - 1, target);
		System.out.println("index is " + index);
	}

	public static int binarySearch(int[] nums, int start, int end, int target) {
		if (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				return binarySearch(nums, mid + 1, end, target);
			} else {
				return binarySearch(nums, start, mid - 1, target);
			}
		}
		return -1;
	}
}
