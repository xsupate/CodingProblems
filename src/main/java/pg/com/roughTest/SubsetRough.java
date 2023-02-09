package pg.com.roughTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SubsetRough {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
        getAllSubsets(nums).forEach(s -> System.out.print(s + " ")); 
	}
	
	public static List<List<Integer>> getAllSubsets(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());

		Arrays.stream(nums).forEach(num -> {
			IntStream.range(0, result.size()).forEach(i -> {
				List<Integer> newList = new ArrayList<Integer>(result.get(i));
				newList.add(num);
				result.add(newList);
			});
		});
		
		return result;
	}

}
