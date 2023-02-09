package pg.com.ds.strings;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
	
public class LongestCommonPrefix {

	public static void main(String[] args) {
       String[] strs = {"flower","flow","flight"};
       System.out.println("Longest common prefix is " + longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        
        return prefix;
    }
}
