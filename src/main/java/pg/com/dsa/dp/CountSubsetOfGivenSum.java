package pg.com.dsa.dp;

public class CountSubsetOfGivenSum {

	public static void main(String[] args) {
		int[] nums = {2,3,5,6,8,10};
        int k = 10;
        System.out.println("Count of subset with sum 10 is " + canPartition(nums, k));
	}

	public static int canPartition(int[] nums, int target) {
		
		int[][] dp = new int[nums.length + 1][target + 1];
		for(int i = 0; i < nums.length; i++)
			dp[i][0] = 0;
		
		

		for (int i = 0; i <= nums.length; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= nums.length; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i - 1] <= j) {
					dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[nums.length][target];
	}
}
