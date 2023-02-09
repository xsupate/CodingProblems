package pg.com.ds.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {
	
	List<Integer> list;
    int k;

    public KthLargest(int k, int[] nums) {
        list = new ArrayList<>();
        this.k = k;
        for(int i : nums)
            list.add(i);
    }
    
    public int add(int val) {
    	list.add(val);
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        list.forEach(s-> {
        	pQueue.add(s);
        	if(pQueue.size() > k){
                pQueue.poll();
            }
        });
        
        return pQueue.peek();
    }

	public static void main(String[] args) {
		int[] nums = {4, 5, 8, 2};
		int k = 3;
		KthLargest obj = new KthLargest(k, nums);
		System.out.println(obj.add(3));
		System.out.println(obj.add(5));
		System.out.println(obj.add(10));
		System.out.println(obj.add(9));
		System.out.println(obj.add(4));
	}

}
