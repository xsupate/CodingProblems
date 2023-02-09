package pg.com.ds.arrays;

public class ReverseArray {

	public static void main(String[] args) {
       int[] nums = {25,22,19,17,14,11,9,6,4,1};
       
       for(int temp : reverse(nums)) {
    	   System.out.print(" " + temp);
       }
       
       System.out.println();
       
       for(int temp : reverse(nums)) {
    	   System.out.print(" " + temp);
       }
	}

	public static int[] reverse(int[] arr) {
		int start = 0; 
		int end = arr.length-1;
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
		return arr;
	}
}
