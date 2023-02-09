package pg.com.ds.strings;

public class StringToInteger {

	public static void main(String[] args) {
         String s = "4234 with words";
         System.out.println(myAtoi(s));
	}

	public static int myAtoi(String s) {
		char[] str = s.toCharArray();
        int startIndex = 0;
        while(startIndex < s.length() && str[startIndex] == ' ')
        	startIndex++;
        
        if(startIndex >= s.length()) return 0;
        
        int sign = 1;
        if(str[startIndex] == '+' || str[startIndex] == '-') {
        	sign = str[startIndex] == '+' ? 1:-1;
        	startIndex++;
        }
        if(startIndex >= s.length()) return 0;
        
        int num = 0;
        
        for(;startIndex < s.length() && Character.isDigit(str[startIndex]); startIndex++){
        	
        	if(num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 &&
        			str[startIndex] - '0' > Integer.MAX_VALUE%10)) {
        		return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	}
        	num = num*10 + str[startIndex]-48;
        }
		return sign*num;
	}

}
