package pg.com.dsa.dp;

/*
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
 * in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and
 * weights associated with n items respectively. Also given an integer W which represents knapsack capacity, 
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal
 * to W. 
 * 
 * int val[] = new int[] { 60, 100, 120 };
 * int wt[] = new int[] { 10, 20, 30 };
 * int W = 50;
 * Answer : 220
 */
public class KanpSack01Memoization {
    static int[][] t;
	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		
		t = new int[val.length+1][W+1];
		populateTheDPMatrix(val.length+1, W+1);
		System.out.println("Maximum profit is " + solveKnapSack(val,wt,W, val.length));
		System.out.println("Maximum profit is " + t[val.length][W]);
	}
	private static void populateTheDPMatrix(int row, int col) {
		for(int i = 0; i <row; i++) {
			for(int j = 0; j <col; j++) {
				t[i][j] = -1;
			}
		}
		
	}
	private static int solveKnapSack(int[] val, int[] wt, int w, int n) {
		if(n == 0|| w == 0) {
			return 0;
		}
		if(t[n][w] != -1)
			return t[n][w];
		
		if(wt[n-1] <= w) {
			t[n][w] = Math.max(val[n-1]+ solveKnapSack(val,wt,w-wt[n-1], n-1), solveKnapSack(val,wt,w, n-1));
		}else {
			t[n][w] = solveKnapSack(val,wt,w, n-1);
		}
		return t[n][w];
	}

}
