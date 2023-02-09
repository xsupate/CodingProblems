package pg.com.roughTest;

public class BinomialExpression {

	public static void main(String[] args) {
       int n = 5;
       int b = 6;
       int sum=0;
       while(n>=0) {
    	   sum = sum + ((int)Math.pow(2,n))*b;
    	   n = n-1;
       }
       
	}

}
