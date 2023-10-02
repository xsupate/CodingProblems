package pg.com.dsa.dp;

public class CoinChangeProblemNoOfWays {
   
	public static void main(String[] args) {
		int coins[] = {1,2};
		int sum = 5;
		System.out.println("Number of ways : " + coinChangeProblem(coins, sum));

	}
	
	public static int coinChangeProblem(int coins[], int sum) {
		int size = coins.length;
		 int dp[][] = new int[size+1][sum+1];
		 for(int i =  1; i <= sum; i++)
			 dp[0][i] = 0;
		 
		 for(int i =  1; i <= size; i++)
			 dp[i][0] = 1;
		 
		 for(int i = 1; i <= size; i++) {
			 for(int j = 1; j <= sum; j++) {
				 if(j >= coins[i-1] ) {
					 dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
				 }else {
					 dp[i][j] =  dp[i-1][j];
				 }
			 }
		 }
		 
		 return dp[size][sum];
	}

}
