package pg.com.dsa.dp;

// https://www.youtube.com/watch?v=bUSaenttI24
	
public class KanpSack01DPSolution {
	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		System.out.println("Kanpsack max profit value " + knapSackDP(W, wt,val,val.length));
	}

	

	static int knapSackDP(int W, int wt[], int val[], int n) {
		int i, j;
		int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					K[i][j] = 0;
				else if (wt[i - 1] <= j)
					K[i][j] = Math.max(val[i - 1] + K[i - 1][j - wt[i - 1]], K[i - 1][j]);
				else
					K[i][j] = K[i - 1][j];
			}
		}

		return K[n][W];
	}

}
