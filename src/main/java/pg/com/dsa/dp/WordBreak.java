package pg.com.dsa.dp;

import java.util.Arrays;
import java.util.List;

/*Given a string s and a dictionary of strings wordDict, return true if s can be segmented into 
a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".*/

public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = Arrays.asList("leet","code");
        System.out.println(" " + wordBreak(s, wordDict));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        int maxLen = 0;
        for(String str : wordDict)
            maxLen = Math.max(maxLen, str.length());
        
        for(int i = 0;  i <= n; i++){
            for(int j=0; j < i; j++){
                if(i-j > maxLen)
                    continue;
                
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
