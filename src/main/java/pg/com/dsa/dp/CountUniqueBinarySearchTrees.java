package pg.com.dsa.dp;

public class CountUniqueBinarySearchTrees {

	public static void main(String[] args) {
		int n = 3;
		System.out.println("Number of unique BST " + numTrees(n));

	}
	
	public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i < n+1; i++){
            int l = 0;
            int r = i-1;
            while(l<= i-1){
                dp[i] += dp[l]*dp[r];
                l++;
                r--;
            }
        }
        return dp[n];
    }

}
