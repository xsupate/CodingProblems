package pg.com.java8.examples;

import java.util.Arrays;
import java.util.List;

public class StringJoinMethodExample {

	public static void main(String[] args) {
		// Joining strings using ',' delimiter
		List<String> payCompanies = Arrays.asList("Apple pay", "Samsung Pay", "Paypal");
		String wallats = String.join(",", payCompanies);
		System.out.println("electronic wallats : " + wallats);

		
		// Joining arbitrary number of String
		String combined = String.join(" and ", "LinkedIn", "Microsoft");
		System.out.println("string joined by and : " + combined);
		
		
		// joining elements from a list of String
		String joined = String.join("|", Arrays.asList("Java", "Android", "Oracle"));
		System.out.println("String joined by pipe from list : " + joined);
		
		
		// joining String elements of an array
		String[] biggies = { "Apple", "Google", "Amazon" };
		String fromArray = String.join(",", biggies);
		System.out.println("String joined by comma from array: " + fromArray);

	}

}
