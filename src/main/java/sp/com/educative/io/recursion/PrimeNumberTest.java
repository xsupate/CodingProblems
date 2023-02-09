package sp.com.educative.io.recursion;

/**
 * A prime number is a number greater than 1 that has only two divisors: 1 and the number itself.
 * The first few prime numbers are: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, .....
 * @author sunipate
 *
 */
public class PrimeNumberTest {

	public static void main(String[] args) {
		int num = 24;
        System.out.println(num + " is a prime numeber : " + isPrime(num, num/2));
	}

	public static boolean isPrime(int num, int i) {
		if(num < 2) {
			return true;
		}else if(i == 1) {
			return true;
		}else if(num%i == 0) {
			return false;
		}
		
		return isPrime(num, i-1);
	}
}
