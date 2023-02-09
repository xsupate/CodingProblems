package pg.com.ds.strings;

public class StringStrStr {

	public static void main(String[] args) {
     String haystack = "mississippi", needle = "issipi";
     System.out.println(strStr(haystack, needle));
	}

	public static int strStr(String haystack, String needle) {
		if(needle.length() == 0) return 0;
		
		int m = haystack.length();
		int n = needle.length() ;
		if(m < n) return -1;
		
        int i = 0, j = 0;
        for(;i <=m-n ; ++i) {
        	for(j=0; j < n ; ++j) {
        		if(haystack.charAt(i+j) != needle.charAt(j))
        			break;
        	}
        	
        	if(j == n) {
            	return i;
            }
        }
        
        return -1;
	}
}
