package pg.com.roughTest;

public class Solution {

	public static void main(String[] args) {
		int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		System.out.println("town judege is " + findJudge(4,trust));
	}

	public static int findJudge(int n, int[][] trust) {
		int[] trust1 = new int[n+1];
		int[] trustedBy = new int[n+1];
		
        for(int i = 0; i < trust.length; i++) {
        	trust1[trust[i][0]] = trust1[trust[i][0]] + 1;
        	trustedBy[trust[i][1]] = trustedBy[trust[i][1]] + 1 ;
        }
		
	    for(int i =1; i < n+1;i++) {
	    	if(trustedBy[i] == n-1 && trust1[i] == 0) {
	    		return i;
	    	}
	    }
	    return -1;
	}
}
