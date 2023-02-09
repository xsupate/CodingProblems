package pg.com.ds.stack;

import java.util.Stack;

public class NearestSmallerNumberOnLeft {

	public static void main(String[] args) {
		int arr[] = {1, 6, 4, 10, 2, 5};
		for (int num : nextSmallerNumberInLeft(arr)) {
			System.out.print(num + " ");
		}
	}

	public static int[] nextSmallerNumberInLeft(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = -1;
		Stack<Integer> st = new Stack<>();
		st.push(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			while (!st.isEmpty() && st.peek() > nums[i]) {
				st.pop();
			}
			if (st.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = st.peek();
			}
			st.push(nums[i]);
		}

		return result;
	}
}
