package pg.com.roughTest;

import java.util.HashSet;
import java.util.Set;

public class NumberAndHisDoubleExist {

	public static void main(String[] args) {
		//3,1,7,11
       System.out.println("Number and it's double exist : " + checkIfExist(new int[]{14,1,7,11}));
       System.out.println("checkPerfectNumber : " + checkPerfectNumber(6));
       //System.out.println("char at " + "acb".charAt(5));
       String[] strs = {"dog","racecar","car"};
       System.out.println("longestCommonPrefix : " + longestCommonPrefix(strs));
	}

	 public static boolean checkIfExist(int[] arr) {
	      Set<Integer> values = new HashSet<>();
	      for(int i : arr) {
	    	  if(values.contains(2*i) || (i%2 == 0 && values.contains(i/2))) {
	    		  return true;
	    	  }
	    	  values.add(i);
	      }
	      
	      return false; 
	    }
	 
	 public static boolean checkPerfectNumber(int num) {
	        int sum = 0;
	        for(int i = 1; i*2 <= num; i++){
	           if(num%i == 0){
	               sum = sum + i; 
	           } 
	        }
	        
	        return num == sum;
	    }
	 
	 public static String longestCommonPrefix(String[] strs) {
	        int startIndex = 0;
	        StringBuilder prefix = new StringBuilder();
	        char ch = ' ';
	        for(int i = 0 ; i < 200; i++){
	            try{
	               ch = strs[0].charAt(startIndex);  
	               for(String str : strs){
	                   if(str.charAt(startIndex) == ch){
	                       continue;
	                   }else{
	                       return prefix.toString();
	                   }
	               }
	               prefix.append(ch);
	              startIndex++;
	            }catch(StringIndexOutOfBoundsException exp){
	                return prefix.toString();
	            }    
	        }
	       return prefix.toString(); 
	    }
}
