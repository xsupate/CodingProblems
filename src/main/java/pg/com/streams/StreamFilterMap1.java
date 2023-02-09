package pg.com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamFilterMap1 {

	public static void main(String[] args) {
         List<String> nums = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
         List<Integer> evenNums = nums.stream().map(s -> Integer.valueOf(s))
        		 .filter(s-> s%2 == 0).collect(Collectors.toList());
         evenNums.stream().forEach(s -> System.out.print(s+ " "));
         System.out.println();
         "ram".equals("");
         
         List<String> names = Arrays.asList("Ram", "Ram", "Shyam", "Anil", "Amit", "Niharika");
         Map<String,Integer>nameLengthMap = names.stream().distinct().collect(Collectors.toMap(s->s, s -> s.length()));
         nameLengthMap.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " : " + s.getValue()));
	}
}

