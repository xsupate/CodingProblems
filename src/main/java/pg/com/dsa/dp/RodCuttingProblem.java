package pg.com.dsa.dp;

public class RodCuttingProblem {

	public static void main(String[] args) {
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		int[] len =   {1, 2, 3, 4, 5,  6,  7,  8};
        System.out.println("max profit is " + getMaxProfit(len, prices, len.length));
	}
	
	public static int getMaxProfit(int[] len, int[] prices, int w) {
		int n = len.length;
		int[][] t = new int[n+1][w+1];
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= w; j++) {
				if(i == 0|| j==0) {
					t[i][j] = 0;
				}else if(len[i-1] <= j) {
					t[i][j] = Math.max(prices[i-1] + t[i][j-len[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][w];
	}

}
