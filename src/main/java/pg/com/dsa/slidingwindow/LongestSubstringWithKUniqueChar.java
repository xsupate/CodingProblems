package pg.com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChar {

	public static void main(String[] args) {
        String str = "aabbcc";
        int k = 2;
        System.out.println("Max length is " + getLongestSubString(str, k));
	}

	public static int getLongestSubString(String str, int k) {
        int res = Integer.MIN_VALUE;
        String resStr = "";
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while(j < str.length()) {
        	if(map.size() <= k) {
        		map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
        		if(map.size() == k) {
        			if(j-i+1 > res) {
        				resStr = str.substring(i, j+1);
        				res = Math.max(res, j-i+1);
        			}
        		}
        	}
        	
        	while(map.size() > k) {
        		if(map.get(str.charAt(i)) == 1){
        			map.remove(str.charAt(i));
        		}else {
        			map.put(str.charAt(i), map.get(str.charAt(i))-1);
        		}
        		i++;
        	}
        	j++;
        }
        
        System.out.println("String " + resStr);
        return res;
	}
}
