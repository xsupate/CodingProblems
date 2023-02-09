package pg.com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParantheses {
	static List<String> result = new ArrayList<>();
	static Set<String> set1 = new HashSet<>();
	public static void main(String[] args) {
       String str = "(a)())()";
       for(String s : removeInvalidParentheses(str)) {
    	   System.out.print(s + " ");
       }
	}

	public static List<String> removeInvalidParentheses(String s) {
	      int mra =   getMinToRemove(s);
	      Set<String> set = new HashSet<>();
	      removeParaentheses(s,mra, set);
	      return  result;
	    }
	    
	    private static int getMinToRemove(String str){
	        Stack<Character> s = new Stack<>();
		        for(Character ch : str.toCharArray()){
		            if(ch == '('){
		                s.push(ch);
		            }else if(ch == ')' && !s.isEmpty() && s.peek() == '('){
		                s.pop();
		            }else if(ch == ')'){
		                s.push(ch);
		            }
		        }
		        return s.size();
	    }
	    
	    private static void removeParaentheses(String s, int mra, Set<String> strs){
	        if(mra == 0){
	            if(getMinToRemove(s) == 0 && !strs.contains(s)){
	                strs.add(s);
	                result.add(s);
	            }
	        }
	        
	        for (int i = 0; i < s.length(); i++) {
				String left = s.substring(0, i);
	            String right = s.substring(i+1);
	            if(!set1.contains(left+right)){ 
	                set1.add(left+right);
	                removeParaentheses(left+right , mra - 1, strs);
	            } 
			}
	    }
	    
	    public List<Integer> partitionLabels(String s) {
	        List<Integer> results = new ArrayList<>();
	        Map<Character, Integer> map = new HashMap<>();
	        for(int i = 0; i < s.length(); i++){
	            map.put(s.charAt(i), i);
	        }
	        
	        int prev = -1;
	        int max = -1;
	        
	        for(int i = 0; i < s.length(); i++){
	             max = map.get(s.charAt(i));
	            while(map.get(s.charAt(i)) < max){
	                i++;
	            }
	            if(max == map.get(s.charAt(i))){
	                results.add(max-prev);
	                prev = max;
	                
	            }      
	        }
			return results;    
	    }
}
