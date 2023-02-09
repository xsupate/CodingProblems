package pg.com.ds.strings;

/*
 * Given a string s, reverse the order of characters in each word within a sentence while 
 * still preserving whitespace and initial word order.
 * 
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInAStringIII {

	public static void main(String[] args) {

	}
	
	public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length;){
            int startIndex = i;
            while(startIndex < chars.length && chars[startIndex] == ' '){
               startIndex++; 
            }
            
            int endIndex = i;
            
            while(endIndex < chars.length && chars[endIndex] != ' '){
                endIndex++;
            }
            
            if(startIndex < endIndex-1){
                reverse(chars,startIndex,endIndex-1);
            }
            i=endIndex+1;
        }
        
        return new String(chars);
    }
    
    
    private static void reverse(char[] chars, int start, int end){
        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}
