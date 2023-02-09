package pg.com.streams;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HorizantalToVerticalTransform {

	public static void main(String[] args) {
		String[] names = {"Ashish", "ABC", "Murthi", "Dharmender"};
		Stream.of(method(names)).forEach(System.out::println);
	}

	public static String[] method(String[] args){
		   int n = Stream.of(args).map(String::length).max(Comparator.comparing(Integer::valueOf)).get().intValue();
		   StringBuilder[] temp = new StringBuilder[n];
		 
		   IntStream.range(0,n).forEach(i -> temp[i] = new StringBuilder(""));
		   
		   Stream.of(args).forEach(s -> {
			   IntStream.range(0,n).forEach(i -> {
				   if(i < s.length()) {
					   temp[i].append(s.charAt(i)); 
				   }else {
					   temp[i].append(' '); 
				   }
			   }); 
		   });
		   
		   String[] result = new String[n];
		   int i = 0;
		   for(StringBuilder str : temp) {
			   result[i++] = str.toString();
		   }
		
		   return result;
		}
}
