package pg.com.ds.heap;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,4,7},{2,5,9}};
		int k = 3;
		int result = Integer.MIN_VALUE;
		PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++ ) {
        	for(int j = 0; j < matrix[0].length; j++ ) {
        		pq.add(new Node(matrix[i][j]));
        	}
        }
        
        for(int i = 0; i < k; i++) {
        	Node temp = pq.poll();
        	if(i == k-1) {
        		result = temp.val;
        	}
        }
        
        System.out.println("kth smallest number is " + result);
	}
	
	static class Node implements Comparable<Node>{
	    Integer val;
	    
	    public Node(Integer val){
	        this.val = val;
	    }

		@Override
		public int compareTo(Node o) {
			return this.val.compareTo(o.val);
		} 
	}
}

