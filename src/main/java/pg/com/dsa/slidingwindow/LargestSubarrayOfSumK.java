package pg.com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayOfSumK {

	public static void main(String[] args) {
       int[] arr =  {6, 8, 14, 9, 4, 11, 10};
       int  sum = 13;
       System.out.println("Maximum length of subarray is " + getMaxLengthOfSubArray(arr, sum));
       System.out.println("Maximum length of subarray is " + getMaxLength(arr, sum));
	}

	public static int getMaxLengthOfSubArray(int[] arr, int k) {
		int maxLen = Integer.MIN_VALUE, sum = 0;
		for(int i = 0,j = 0; i < arr.length; i++) {
			while(j < arr.length) {
				sum = sum + arr[j];
				if(sum < k) {
					j++;
				}else if(sum == k) {
					maxLen = Math.max(maxLen, j-i+1);
					j++;
				}else if(sum > k) {
					while(sum > k) {
						sum = sum - arr[i];
						i++;
					}
					j++;
				}
			}
		}
		
		return maxLen;
	}
	
	// Using Hash method 
	public static int getMaxLength(int[] arr, int k) {
		int sum = 0, maxLen = Integer.MIN_VALUE; 
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			sum = sum+arr[i];
			if(sum == k) {
				maxLen = Math.max(maxLen, i+1);
			}
			
			if(!map.containsKey(sum))
				map.put(sum, i);
			
			int remains = sum-k;
			if(map.containsKey(remains)) {
				maxLen = Math.max(maxLen, i-map.get(remains));
			}
		}
		return maxLen;
	}
}
