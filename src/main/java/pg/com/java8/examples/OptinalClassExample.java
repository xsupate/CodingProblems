package pg.com.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptinalClassExample {
	private static List<String> listOfBooks = Arrays.asList("Effective Java", "Clean Code", "Test Driven");

	public static void main(String[] args) {

	}

	/*
	 * Return the first book start with a letter.
	 */
	public static String getBook(String letter) {
		Optional<String> book = listOfBooks.stream().filter(b -> b.startsWith(letter)).findFirst();
		
		//return book.isPresent() ? book.get() : "Book Not Found";
		
		/*
		 * The OrElse() method is much nicer than the combination of isPresent() and get().
		 */
		
		return book.orElse("Book Not Found");
	}

	
}
