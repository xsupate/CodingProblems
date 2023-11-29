package pg.com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {
		List<List<Integer>> nestedNumbers = Arrays.asList(
			    Arrays.asList(1, 2, 3),
			    Arrays.asList(4, 5, 6),
			    Arrays.asList(7, 8, 9)
			);
		   
			List<Integer> flattenedNumbers = nestedNumbers.stream().flatMap(s-> s.stream()).collect(Collectors.toList());
			System.out.println("flattenedNumbers   " + flattenedNumbers);
			flattenedNumbers = nestedNumbers.stream().flatMap(List::stream).collect(Collectors.toList());
			System.out.println("flattenedNumbers - " + flattenedNumbers);
			
			
			List<String> words = Arrays.asList("Java", "Stream", "API");
			List<String> filteredWords = words.stream()
			                                .filter(word -> word.length() > 3)
			                                .collect(Collectors.toList());
			System.out.println("filteredWords " + filteredWords);// Result: ["Java", "Stream"]
			System.out.println(words.stream().allMatch(s-> s.length() > 3));
			List<Integer> list = new ArrayList<>();
	        System.out.println("Any match returns " + list.stream().anyMatch(number -> number > 0)); // false if stream empty anyMatch return false
	        System.out.println("All match returns " + list.stream().allMatch(number -> number > 0)); // true if stream empty allMatch return true
	        System.out.println("noneMatch returns " + list.stream().noneMatch(number -> number > 0));// true if stream empty noneMatch return true 
	}

}
