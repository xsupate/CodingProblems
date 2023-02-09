package pg.com.ds.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		for(int i : topKFrequent(nums,k))
			System.out.println(i);

	}
	
	public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
        map.entrySet().forEach(s -> {
        	pQueue.add(new Node(s.getKey(), s.getValue()));
        	if(pQueue.size() > k)
        		pQueue.poll();
        });
        
        int[] res = new int[k];
        int i = 0;
        while(!pQueue.isEmpty()) {
        	Node temp = pQueue.poll();
        	res[i++] = temp.key;
        }
        return res;
    }

}

class Node implements Comparable<Node>{
	Integer key;
	Integer count;
	
	public Node(int key, int count) {
		this.key = key;
		this.count = count;
	}

	@Override
	public int compareTo(Node o) {
		return this.count.compareTo(o.count);
	}
	
}
