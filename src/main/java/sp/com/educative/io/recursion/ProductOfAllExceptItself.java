package sp.com.educative.io.recursion;

import java.util.Arrays;

public class ProductOfAllExceptItself {

	public static void main(String[] args) {
		int[] nums = {4,2,1,5,0};
		Arrays.stream(productArray(nums)).forEach(s -> System.out.print(s +" "));
	}
	
	public static int[] productArray(int[] nums) {
		int n = nums.length;
		
		int[] result = new int[n];
		int temp = 1, i;
		for(i = 0; i < n; i++) {
			result[i] = temp;
			temp *=nums[i];
		}
		
		temp = 1;
		for(i = n-1; i >= 0; i--) {
			result[i] *= temp;
			temp *= nums[i]; 
		}
		
		return result;
	}

}
