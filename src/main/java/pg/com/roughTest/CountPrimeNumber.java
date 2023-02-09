package pg.com.roughTest;

public class CountPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("Count of prime : " + countPrimes(10));
	}

	public static int countPrimes(int n) {
        int count=0;
        if(n<=2) {
        	return 0;
        }
        
        boolean[] primes = new boolean[n];
        for(int i = 2; i < n; i++) {
        	primes[i] = true;
        }
        
        for(int i = 2; i * i < n; i++) {
        	if(primes[i]) {
        		for(int j=i+i; j < n; j= j+i) {
        				primes[j] = false;
        		}
        	}
        }
        
        for(int i = 2; i < n; i++) {
        	if(primes[i])
        		count++;
        }
        
        return count;
    }
}
