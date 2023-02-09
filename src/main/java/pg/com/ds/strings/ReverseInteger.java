package pg.com.ds.strings;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = 1534236469;
    	System.out.println(reverse(x));
	}

	public static int reverse(int x) {
        boolean isNegative = x < 0 ? true:false;
        x = isNegative ? x*(-1) : x;
        int rem = 0;
        long rev = 0;
        while(x > 0){
            rem = x%10;
            rev = rev*10 + rem;
            x = x/10;
        }
        
        if(rev > Integer.MAX_VALUE)
                return 0;
          
        return isNegative ? (int)rev*(-1) : (int)rev;
    }
}
