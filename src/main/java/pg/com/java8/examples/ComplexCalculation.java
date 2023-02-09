package pg.com.java8.examples;

import java.math.BigInteger;

public class ComplexCalculation {
	
	public static void main(String[] str) {
		ComplexCalculation obj = new ComplexCalculation();
		BigInteger res = obj.calculateResult(new BigInteger("10"), new BigInteger("2"), new BigInteger("10"),
				new BigInteger("3"));
		System.out.println("result " + res);
	}
	
	
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        
        PowerCalculatingThread t1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread t2 = new PowerCalculatingThread(base2, power2);
        
        
        try {
        	t1.start();
            t2.start();
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        result = t1.getResult().add(t2.getResult());
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
        	result = result.multiply(base);
    		for(int i = 1; i < power.intValue(); i++) {
    			result = result.multiply(base);
    		}
        }
    
        public BigInteger getResult() { return result; }
    }
}
