package pg.com.ds.arrays;

public class ArrayRotation {
     
	public static void main(String[] args) {
		int[] nums = {-1,-100,3,99};
		rotate(nums, 2);
		for(int a: nums) {
			System.out.print(a + " ");
		}
	}
	
	private static void rotate(int[] arr, int d) {
		d = d % arr.length;
		if(d > 0) {
			/*reverseArray(arr, 0, d-1);
			reverseArray(arr, d, arr.length-1);
			reverseArray(arr, 0, arr.length-1);*/
			reverseArray(arr, 0, arr.length-1-d);
			reverseArray(arr, arr.length-d, arr.length-1);
			reverseArray(arr, 0, arr.length-1);
		}
	}

	private static void reverseArray(int[] arr, int start, int end) {
          while(start < end) { 
        	  int temp = arr[start];
        	  arr[start] = arr[end];
        	  arr[end] = temp;
        	  start++;
        	  end--;
          }
	}
}
