package pg.com.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsWithDublicate {

	public static void main(String[] args) {
		

	}
	
	public static List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null)
		return null;
 
	Arrays.sort(num);
 
	List<List<Integer>> result = new ArrayList<>();
	List<List<Integer>> prev = new ArrayList<>();
 
	for (int i = num.length-1; i >= 0; i--) {
 
		//get existing sets
		if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
			prev = new ArrayList<>();
			for (int j = 0; j < result.size(); j++) {
				prev.add(new ArrayList<Integer>(result.get(j)));
			}
		}
 
		//add current number to each element of the set
		for (List<Integer> temp : prev) {
			temp.add(0, num[i]);
		}
 
		//add each single number as a set, only if current element is different with previous
		if (i == num.length - 1 || num[i] != num[i + 1]) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(num[i]);
			prev.add(temp);
		}
 
		//add all set created in this iteration
		for (List<Integer> temp : prev) {
			result.add(new ArrayList<Integer>(temp));
		}
	}
 
	//add empty set
	result.add(new ArrayList<Integer>());
 
	return result;
	}

	
	public List<List<Integer>> subsetsWithDuplicate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void subset(int[] nums, int start, List<Integer> current, List<List<Integer>> total) {
        total.add(new ArrayList<Integer>(current));

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                current.add(nums[i]);
                subset(nums, i+1, current, total);
                current.remove(current.size() - 1);
            }
        }
    }
}
