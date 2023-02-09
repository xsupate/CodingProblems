package pg.com.dsa.dp;

public class LongestCommonSubstringLen {
	static int t[][] ;
	static int max=0;
	public static void main(String[] args) {
		String str1 = "zxabcdezy";
		String str2 = "yzabcdezx";
		System.out.println("Length of LCS(DP) is " + longestCommonSubstringeDP(str1,str2));
	}

	private static int longestCommonSubstringeDP(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		t = new int[m+1][n+1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n ; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
					if(t[i][j] > max)
						max = t[i][j];
				} else {
					t[i][j] = 0;
				}
			}
		}

		return max;
	}
}
