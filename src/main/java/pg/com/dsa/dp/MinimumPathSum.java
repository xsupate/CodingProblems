package pg.com.dsa.dp;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int[][] dp = new int[grid.length][grid[0].length];  
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                dp[i][j] += grid[i][j];
                if(i > 0 && j > 0){
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                }else if(i > 0){
                    dp[i][j] += dp[i-1][j];
                }else if(j > 0){
                     dp[i][j] += dp[i][j-1];
                }
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
    }
}
