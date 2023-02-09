package pg.com.ds.stack;

import java.util.Stack;

public class NextGreaterElementInRight {

	public static void main(String[] args) {
         int[] nums = {5,3,2,6,7,18,1,9};
         for(int num : nextGreaterEle(nums)) {
        	 System.out.print(num + " ");
         }
	}

	public static int[] nextGreaterEle(int[] nums){
        int[] result = new int[nums.length];
        result[nums.length-1] = -1;
        Stack<Integer> s = new Stack<>();
        s.push(nums[nums.length-1]);
        for(int i = nums.length-2; i >= 0; i--) {
        	while(!s.isEmpty() && nums[i] > s.peek()) {
        		s.pop();
        	}
        	if(s.isEmpty()) {
        		result[i] = -1;
        	}else {
        		result[i] = s.peek();
        	}
        	
        	s.push(nums[i]);
        }
        
        return result;
    }
}
