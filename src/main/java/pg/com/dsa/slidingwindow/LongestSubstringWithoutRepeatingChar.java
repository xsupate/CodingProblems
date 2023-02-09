package pg.com.dsa.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {

	public static void main(String[] args) {
		

	}

	public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int curr = 0;
        
        Set<Character> set = new HashSet<>();
        
        while(curr < s.length()){
            if(!set.contains(s.charAt(curr))){
                set.add(s.charAt(curr));
                max = Math.max(set.size(),max);
                curr++;
            }else{
               set.remove(s.charAt(start));
               start++; 
            }
        }
       return max; 
    }
}
