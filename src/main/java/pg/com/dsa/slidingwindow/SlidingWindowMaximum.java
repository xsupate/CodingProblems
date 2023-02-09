package pg.com.dsa.slidingwindow;

import java.util.Stack;

/*
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
 * of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation: 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3 ;
        for(int num : maxSlidingWindow(nums, k)) {
        	System.out.print(num + " ");
        }
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length-k+1];
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        nge[nums.length-1] = nums.length;
        st.push(nums.length-1);
        for(int i = nums.length -2; i >= 0; i--) {
        	//-a+
        	while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
        		st.pop();
        	}
        	
        	if(st.isEmpty()) {
        		nge[i] = nums.length;
        	}else {
        		nge[i] = st.peek();
        	}
        	st.push(i);
        }
        
        for(int i = 0; i <= nums.length-k; i++) {
        	int j = i;
        	while(nge[j] < i+k) {
        		j = nge[j];
        	}
        	result[i] = nums[j];
        }
		
		return result;
    }
	
}
