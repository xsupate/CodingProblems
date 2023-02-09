package pg.com.dsa.dp;

public class LCSRecursive {

	public static void main(String[] args) {
		String str1 = "abcgh";
		String str2 = "abefl";
        System.out.println("length of longest Common Subsequense is " + lcsRecur(str1, str1.length(), str2, str2.length()));
	}

	public static int lcsRecur(String str1, int m, String str2, int n) {
		if(m == 0 || n==0) {
			return 0;
		}
		
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			return 1+ lcsRecur(str1, m-1, str2, n-1);
		}else {
			return Math.max(lcsRecur(str1, m-1, str2, n), lcsRecur(str1, m, str2, n-1));
		}
	}
}
