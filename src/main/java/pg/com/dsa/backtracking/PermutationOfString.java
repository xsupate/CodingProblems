package pg.com.dsa.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PermutationOfString {
	static List<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		String str = "abc";
		getPermutations(str,"");
		result.forEach(s -> System.out.print(" " + s));
	}
	
	public static void getPermutations(String roq, String asf){
		if(roq.length() == 0) {
			result.add(asf);
			return;
		}
		
		for(int i = 0; i < roq.length(); i++) {
			char ch = roq.charAt(i);
			String newRoq = roq.substring(0, i) + roq.substring(i+1);
			getPermutations(newRoq, asf + ch);
		}
	}
	
	public static List<List<Integer>> findPermutations(int[] nums) {
	    List<List<Integer>> result = new ArrayList<>();
	    Queue<List<Integer>> permutations = new LinkedList<>();
	    permutations.add(new ArrayList<>());
	    for (int currentNumber : nums) {
	      // we will take all existing permutations and add the current number to create new permutations
	      int n = permutations.size();
	      for (int i = 0; i < n; i++) {
	        List<Integer> oldPermutation = permutations.poll();
	        // create a new permutation by adding the current number at every position
	        for (int j = 0; j <= oldPermutation.size(); j++) {
	          List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
	          newPermutation.add(j, currentNumber);
	          if (newPermutation.size() == nums.length)
	            result.add(newPermutation);
	          else
	            permutations.add(newPermutation);
	        }
	      }
	    }
	    return result;
	  }

}
