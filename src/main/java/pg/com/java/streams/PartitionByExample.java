package pg.com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionByExample {

	public static void main(String[] args) {
		// Sample list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Partitioning the numbers into even and odd
        Map<Boolean, List<Integer>> evenOddPartition = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        // Display the result
        System.out.println("Even numbers: " + evenOddPartition.get(true));
        System.out.println("Odd numbers: " + evenOddPartition.get(false));

	}

}
