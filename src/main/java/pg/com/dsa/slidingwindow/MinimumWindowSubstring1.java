package pg.com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring1 {

	public static void main(String[] args) {
		String s = "geeksforgeeks", t = "ork";
		System.out.println(" " + minWindow(s,t));
	}

	public static String minWindow(String s, String t) {
	       String ans = s+"";
	       Map<Character, Integer> map = new HashMap<>(); 
	       for(Character ch : t.toCharArray()) {
	    	   map.put(ch, map.getOrDefault(ch, 0)+1);
	       }
	        
	       int i = 0, j=0, count=map.size();
	       
	       while(j < s.length()){
	           char ch = s.charAt(j);
	           if(map.containsKey(ch)){
	              map.put(ch, map.getOrDefault(ch, 0)-1); 
	              if(map.get(ch) == 0){
	                  count--;
	              }
	           }
	           
			while (count == 0) {
				if(ans.length() > j - i + 1) {
					ans = s.substring(i, j+1);
				}
				char ch1 = s.charAt(i);
				if (map.containsKey(ch1)) {
					i++;
					map.put(ch1, map.getOrDefault(ch1, 0) + 1);
					if (map.get(ch1) == 1) {
						count++;
					}
				}else {
					i++;
				}
				
			}
			j++;
		}
	   return ans; 
	}
}
