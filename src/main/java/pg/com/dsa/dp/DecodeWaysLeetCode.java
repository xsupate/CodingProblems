package pg.com.dsa.dp;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * @author skpatel
 *
 */
public class DecodeWaysLeetCode {

	public static void main(String[] args) {
		String input = "12";
		System.out.println("Number of ways to decode : " + numDecodings(input));

	}

	public static int numDecodings(String s) {
		int dp[] = new int[s.length()+1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for(int i = 2; i <= s.length(); i++) {
			int oneDigit = Integer.valueOf(s.substring(i-1, i));
			int twoDigit = Integer.valueOf(s.substring(i-2, i));
			
			if(oneDigit > 0) {
				dp[i] = dp[i-1];
			}
			
			if(twoDigit >= 10 && twoDigit <= 26) {
				dp[i] += dp[i-2];
			}
		}
		return dp[s.length()];
	}
}
