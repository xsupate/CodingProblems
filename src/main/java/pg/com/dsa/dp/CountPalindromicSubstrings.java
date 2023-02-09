package pg.com.dsa.dp;

public class CountPalindromicSubstrings {

	public static void main(String[] args) {
		String str = "abc";
        System.out.println("Palindromic Substrings count " + countSubstrings(str));
	}

	public static int countSubstrings(String s) {
        int count = 0;
        int N = s.length();
        boolean[][] dpm = new boolean[N][N];
        
        for(int g = 0; g < N; g++) {
        	for(int i = 0, j = g;j<N; i++, j++) {
        		if(g == 0) {
        			dpm[i][j] = true;
        		}else if(g == 1) {
        			if(s.charAt(i) == s.charAt(j)) {
        				dpm[i][j] = true;
        			}else {
        				dpm[i][j] = false;
        			}
        		}else {
        			if(s.charAt(i) == s.charAt(j) && dpm[i+1][j-1] == true) {
        				dpm[i][j] = true;
        			}else {
        				dpm[i][j] = false;
        			}
        		}
        		if(dpm[i][j] == true) {
            		count++;
            	}
        	}
        }
        return count;
    }
}
