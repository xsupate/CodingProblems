package sp.com.educative.io.recursion;

public class StringPalindromeTest {

	public static void main(String[] args) {
		String str = "acddca";
		System.out.println("Is " + str + " palindrome : " + isPalindrome(str));

	}

	
	public static boolean isPalindrome(String str) {
		if(str == null || str.isEmpty() || str.length() == 1)
			return true;
		
		int lastIndex = str.length()-1;
		if(str.charAt(0) == str.charAt(lastIndex)) {
			return isPalindrome(str.substring(1,lastIndex));
		}else {
			return false;
		}
	}
}
