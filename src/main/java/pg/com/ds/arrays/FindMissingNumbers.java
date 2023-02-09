package pg.com.ds.arrays;

import java.util.LinkedList;
import java.util.List;

public class FindMissingNumbers {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		
        for(int i : findDisappearedNumbers(nums)){
        	System.out.print(" " + i);
        }
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out = new LinkedList<Integer>();
        int i = 0;
        int n;
        //move each number to position equals their value  
        while(i < nums.length) {
            n = nums[i];
           // if(n == i + 1 || nums[n - 1] == nums[i]) {
            if(nums[n - 1] == n) {	
                i++;
                continue;
            }
            nums[i] = nums[n - 1];
            nums[n - 1] = n;
        }
        //find numbers which differents from array index
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                out.add(i + 1);
            }
        }
        return out;
    }
}
