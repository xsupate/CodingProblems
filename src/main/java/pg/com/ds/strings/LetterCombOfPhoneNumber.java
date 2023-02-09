package pg.com.ds.strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombOfPhoneNumber {
	public static void main(String[] args) {
		String digits = "23";
		letterCombinations(digits).forEach(s-> System.out.print(s+" "));
	}
	
	public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        letterCombinations(result, digits, "", 0, mapping);
        return result;
    }
      
    private static void letterCombinations(List<String>result, String digits, String curr,int index,String[] mapping)     {
       if(index == digits.length()){
          result.add(curr);
          return; 
       }
        
       String letters = mapping[digits.charAt(index) - '0'];
       for(int i = 0; i < letters.length(); i++){
           letterCombinations(result, digits, curr+letters.charAt(i), index+1, mapping);
       } 
    }

}
