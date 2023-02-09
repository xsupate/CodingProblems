package pg.com.dsa.slidingwindow;

public class MaximumSumSubarrayOfSizeK {

	public static void main(String[] args) {
      int[] arr = {1, 4, 2, 10, 23, 3, 1, 0};
      int size = 4;
      System.out.println("Max sum of subarray of size " + size + " is : " + findMaxSumOfSubArray(arr,size));
	}

	public static int findMaxSumOfSubArray(int[] arr, int size) {
		int sum = 0;
		int start = 0;
		for(int i = 0; i < size; i++) {
			sum = sum + arr[i];
		}
		
		int maxSum = sum;
		
		while(++start <= arr.length-size) {
			sum = sum-arr[start-1] + arr[start+size-1];
			if(sum > maxSum) {
				maxSum = sum;
			}
		}
		
		return maxSum;
	}
}
