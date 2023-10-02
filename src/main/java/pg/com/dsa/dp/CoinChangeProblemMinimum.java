package pg.com.dsa.dp;


/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of 
 * the coins, return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 */


public class CoinChangeProblemMinimum {

	public static void main(String[] args) {
		int[] coins = {186,419,83,408};
		int amount = 6249;
        System.out.println("number of coins " + coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {
        int[] dp= new int[amount+1];
        
        for(int amt = 1; amt <= amount; amt++){
        	dp[amt] = Integer.MAX_VALUE;
        	
            for(int i = 0; i < coins.length; i++){ 
                if(coins[i] <= amt && dp[amt - coins[i]] != Integer.MAX_VALUE){
                   dp[amt] = Math.min(dp[amt], 1 + dp[amt - coins[i]]);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount]; 
    }
}
