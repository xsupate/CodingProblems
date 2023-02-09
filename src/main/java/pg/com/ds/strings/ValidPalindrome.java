package pg.com.ds.strings;

public class ValidPalindrome {

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome " + isPalindrome(str));
	}

    public static boolean isPalindrome(String s) {
		int start = 0, end = s.length()-1;
    	while(start < end) {
    		char startChar = s.charAt(start);
    		char endChar = s.charAt(end);
    		if(!isValidChar(startChar)) {
    			start++;
    			continue;
    		}	
    		
    		if(!isValidChar(endChar)) {
    			end--;
    			continue;
    		}
    		
    		if(!String.valueOf(startChar).equalsIgnoreCase(String.valueOf(endChar))) {
    			return false;
    		}
    		
    		start++;
    		end --;
    		
    	}
    	
    	return true;
    }

	private static boolean isValidChar(char ch) {
    	if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch >= '0' && ch <= '9') {
    		return true;
    	}else {
    		return false;
    	}
    }
}
