package pg.com.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class IsValidPalindrome {

	public static void main(String[] args) {
		System.out.println("Is Palindrome : " + isPalindrome("race a car"));
		int[] nums = {1,2,3,1,2,3};
		System.out.println("is dublicate : " + containsNearbyDuplicate(nums,2));	
	}

	public static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()) {
        	if(ch >= 65 && ch <=90) {
        		str.append((char)(ch+32));
        	}else if((ch >= 97 && ch <=122) || (ch >= 48 && ch <=57)) {
        		str.append(ch);
        	}else {
        		continue;
        	}
        }
        
        for(int i = 0, j =str.length()-1; i<j; i++,j--) {
        	if(str.charAt(i) != str.charAt(j)) {
        		return false;
        	}
        }
        
        return true;
    }
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else{
                int index = map.get(nums[i]);
                if((i-index) <= k){
                    return true;
                }else{
                   map.put(nums[i], i); 
                }
            }
        }
        return false;
    }
}
