package pg.com.ds.heap;

import java.util.PriorityQueue;

public class KLargestElements {

	public static void main(String[] args) {
		int[] nums = {2,6,1,5,9,-8,11};
		int k = 3;
		for(int i : kLargestEle(nums, k)) {
			System.out.print(i + " ");
		}

	}
	
	public static int[] kLargestEle(int[] nums, int k) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		for(int num : nums) {
			pQueue.add(num);
			if(pQueue.size() > k) {
				pQueue.poll();
			}
		}
		
		int[] result = new int[k];
		int index = 0;
		while(!pQueue.isEmpty()) {
			result[index++] = pQueue.poll();
		}
		return result;
	}

}
