package pg.com.dsa.dp;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,5};
        System.out.println("Can we partition equal subset sum : " + (canPartition(nums) ? "Yes" : "No"));
	}

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum % 2 == 1) {
			return false;
		}

		int target = sum / 2;
		boolean[][] dp = new boolean[nums.length + 1][target + 1];

		for (int i = 0; i <= nums.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= target; j++) {
				if (nums[i - 1] <= j) {
					dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[nums.length][target];
	}
}
