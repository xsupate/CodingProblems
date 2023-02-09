package pg.com.ds.arrays;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 * Example 1: Input: [-2, -1, 0, 2, 3]  ====>  Output: [0, 1, 4, 4, 9]
 * 
 * Example 2: Input: [-3, -1, 0, 1, 2]  ====>  Output: [0, 1, 1, 4, 9]
 *
 */
public class SortedArraySquares {
	public static void main(String[] args) {
		int[] arr = {-2, -1, 0, 2, 3};
		for(int num : makeSquares1(arr))
			System.out.print(num + " ");
	}
	
  
	public static int[] makeSquares1(int[] arr) {
	    int n = arr.length;
	    int[] squares = new int[n];
	    int highestSquareIdx = n - 1;
	    int left = 0, right = arr.length - 1;
	    while (left <= right) {
	      int leftSquare = arr[left] * arr[left];
	      int rightSquare = arr[right] * arr[right];
	      if (leftSquare > rightSquare) {
	        squares[highestSquareIdx--] = leftSquare;
	        left++;
	      } else {
	        squares[highestSquareIdx--] = rightSquare;
	        right--;
	      }
	    }
	    return squares;
	  }
	
	public static int[] makeSquares(int[] arr) {
	    int[] squares = new int[arr.length];
	    
	    int left = 0;
	    int right = arr.length - 1;
	    int end = arr.length - 1;

	    while(left <= right){
	      if(Math.abs(arr[left]) > Math.abs(arr[right])){
	        squares[end--] =arr[left]*arr[left];
	        left++;
	      }else{
	        squares[end--] = arr[right]*arr[right];
	        right--;
	      }
	    }
	    return squares;
	  }
}


