package pg.com.ds.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {

	public static void main(String[] args) {
      int[] arr = {1,2,3,4,5};
      int x = -1;
      int k = 4;
      findClosestElements(arr,k,x).forEach(s-> System.out.print(s + " "));
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		PriorityQueue<PQueueElement> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		for(int num : arr) {
			if(pQueue.size() < k) {
				pQueue.add(new PQueueElement(num, Math.abs(num-x)));
			}else {
				if(pQueue.peek().absDiff > Math.abs(num-x)) {
					pQueue.remove();
					pQueue.add(new PQueueElement(num, Math.abs(num-x)));
				}
			}
			
		}
		
		List<Integer> result = new ArrayList<>();
		while(!pQueue.isEmpty()) {
			result.add(pQueue.poll().key);
		}
        
        Collections.sort(result);
		return result;
    }
}

class PQueueElement implements Comparable<PQueueElement>{
    Integer key;
    Integer absDiff;
    
    public PQueueElement(int key, int absDiff) {
    	this.key = key;
    	this.absDiff = absDiff;
    }
	
	@Override
	public int compareTo(PQueueElement obj) {
		if(this.absDiff == obj.absDiff) {
			return this.key - obj.key;
		}
		return this.absDiff - obj.absDiff;
	}
}