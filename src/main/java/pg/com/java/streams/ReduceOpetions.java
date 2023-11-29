package pg.com.java.streams;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceOpetions {

	/**
	 * The reduce operation combines the elements of a stream into a single result. 
	 * It takes an associative accumulation function and returns an Optional result.
	 * It is often used to perform operations like sum, multiplication, or finding the maximum value
	 */
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		//Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
		//Optional<Integer> sum = numbers.stream().reduce((a,b) -> a+b);
		//System.out.println("Sum of given number is " + sum.get());
		
		Integer sum = numbers.stream().reduce(0, (a,b) -> a+b);
		System.out.println("Sum of given number is " + sum);
		
		Integer product = numbers.stream().reduce(1, (a, b) -> a*b);
		System.out.println("Product of given number is " + product);
		
		BigInteger multiplication = numbers.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
		System.out.println("multiplication of given number is " + multiplication);
	}
}
