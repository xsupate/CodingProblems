package pg.com.dsa.dp;

public class LongestCommonSubsequence {
	static int t[][] ;

	public static void main(String[] args) {
		String str1 = "pmjghexybyrgzczy";
		String str2 = "hafcdqbgncrcbihkd";
		//System.out.println("Length of LCS(Memo) is " + longestCommonSubsequenceMemo(str1,str2));
		System.out.println("Length of LCS(DP) is " + longestCommonSubsequenceDP(str1,str2));
	}

	public static int longestCommonSubsequenceMemo(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        t = new int[m+1][n+1];
        for(int i = 0; i <=m; i++) {
        	for(int j = 0; j<=n; j++) {
        		t[i][j]=-1;
        	}
        }
        return longestCommonSubsequenceMemo(text1, text2, m, n);
    }
    
    private static int longestCommonSubsequenceMemo(String str1, String str2, int m, int n){
        if(m == 0 || n == 0) 
            return 0;
        
        if(t[m][n] != -1) {
        	return t[m][n];
        }
        
        if(str1.charAt(m-1) == str2.charAt(n-1)){
        	t[m][n] = 1 + longestCommonSubsequenceMemo(str1, str2, m-1, n-1);
        }else{
        	t[m][n] = Math.max(longestCommonSubsequenceMemo(str1, str2, m, n-1),
        			longestCommonSubsequenceMemo(str1, str2, m-1, n));
        }
        
        return t[m][n];
    }
    
    private static int longestCommonSubsequenceDP(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		t = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n ; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
				} else {
					t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
				}
			}
		}

		return t[m][n];
	}
}
