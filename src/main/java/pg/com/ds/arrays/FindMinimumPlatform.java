package pg.com.ds.arrays;

import java.util.PriorityQueue;

public class FindMinimumPlatform {

	public static void main(String[] args) {

	}

	public static int findPlatform(int[] arrival, int[] departure) {
		int count = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arrival.length; i++) {
			if (!pq.isEmpty() && pq.peek() <= arrival[i]) {
				pq.poll();
			} else {
				count++;
			}
			pq.add(departure[i]);
		}

		return count;
	}
}
