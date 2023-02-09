package pg.com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that 
 * every character in t (including duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 * The test cases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.

 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum substring is " + minWindow(s,t));
	}

	public static String minWindow(String s, String t) {
       String ans = "";
       Map<Character, Integer> map2 = new HashMap<>(); 
       for(Character ch : t.toCharArray()) {
    	   map2.put(ch, map2.getOrDefault(ch, 0)+1);
       }
       
       int mtc = 0;
       int dmtc = t.length();
       
       Map<Character, Integer> map1 = new HashMap<>();
       int i = -1;
       int j = -1;
       
       while(i < s.length()-1) {
    	 // acquire
    	 while(i < s.length()-1 && mtc < dmtc) {
    		 i++;
    		 char ch = s.charAt(i);
    		 map1.put(ch, map1.getOrDefault(ch, 0)+1);
    		 
    		 if(map1.get(ch) <= map2.getOrDefault(ch, 0))
    			 mtc++;
    	 }
    	 
    	 while(j < i && mtc == dmtc) {
    		 String pans = s.substring(j+1, i+1);
    		 if(ans.isEmpty() || ans.length() > pans.length())
                     ans = pans;
                     
    		 j++;
    		 char ch = s.charAt(j);
    		 if(map1.get(ch) == 1) {
    			 map1.remove(ch);
    		 }else {
    			 map1.put(ch, map1.get(ch)-1);
    		 }
    		 
    		 if(map2.getOrDefault(ch, 0) > map1.getOrDefault(ch, 0)) {
    			 mtc--;
    		 }
    	 }
       }
       
       return ans;
	}
}
