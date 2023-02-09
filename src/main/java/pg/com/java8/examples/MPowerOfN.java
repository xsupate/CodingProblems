package pg.com.java8.examples;

import java.math.BigInteger;

public class MPowerOfN {

	public static void main(String[] args) {
		BigInteger base = new BigInteger("2");
		BigInteger power = new BigInteger("10");
        System.out.println(power(base, power));
	}
	
	public static BigInteger power(BigInteger base, BigInteger power) {
		BigInteger result = BigInteger.ONE;
		result = result.multiply(base);
		for(int i = 1; i < power.intValue(); i++) {
			result = result.multiply(base);
		}
		return result;
	}

}
