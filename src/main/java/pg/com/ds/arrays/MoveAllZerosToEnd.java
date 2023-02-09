package pg.com.ds.arrays;

public class MoveAllZerosToEnd {

	public static void main(String[] args) {
		int[] arr= {0, 0, 0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		moveAllZeroToEnd(arr);
		for(int i : arr) {
			System.out.print(" " + i);
		}
	}

	public static void moveAllZeros(int[] nums) {
		int count = 0;
		for(int i= 0 ; i < nums.length; i++) {
		    if(nums[i] != 0) {
		    	nums[count++] = nums[i]; 
		    }
		}
		
		while(count < nums.length) {
			nums[count++] = 0;
		}
	}
	
	public static void moveAllZeroToEnd(int[] nums) {
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				int temp = nums[count];
				nums[count] = nums[i];
				nums[i] = temp;
				count++;
			}
		}
	}
}
