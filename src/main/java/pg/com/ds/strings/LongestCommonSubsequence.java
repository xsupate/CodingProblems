package pg.com.ds.strings;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "pmjghexybyrgzczy";
		String str2 = "hafcdqbgncrcbihkd";
		System.out.println("Length of LCS is " + longestCommonSubsequence(str1,str2));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        return longestCommonSubsequence(text1, text2, m, n);
    }
    
    private static int longestCommonSubsequence(String str1, String str2, int m, int n){
        if(m == 0 || n == 0) 
            return 0;
        
        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return 1 + longestCommonSubsequence(str1, str2, m-1, n-1);
        }else{
           return  Math.max(longestCommonSubsequence(str1, str2, m, n-1), longestCommonSubsequence(str1, str2, m-1, n));
        }
    }
}
