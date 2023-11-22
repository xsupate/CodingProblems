package pg.com.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].	
 */	

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{9,18}};
		for(int[] interval : merge(intervals)) {
			System.out.print("["+ interval[0] + " " + interval[1] +"] ");
		}
		
		int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        printIntervals(getMergedIntervals(arr));
	}

	private static void printIntervals(List<List<Integer>> ans) {
		System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
	}
	
	public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null) 
            return res.toArray(new int[0][]);
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] i : intervals) {
            if(i[0] <= end) {
                end = Math.max(end, i[1]);
            }
            else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start, end});
       return res.toArray(new int[0][]);
    }
	
	public static List<List<Integer>> getMergedIntervals(int[][]  arr){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);
		
		int start = arr[0][0];
		int end = arr[0][1];
		result.add(Arrays.asList(start, end));
		for(int[] curr : arr) {
			if(curr[0] < end) {
				end = Math.max(end, curr[1]);
				result.get(result.size()-1).set(1, end);
			}else {
				start = curr[0];
				end = curr[1];
				result.add(Arrays.asList(start, end));
			}
		}
		
		return result;
	}
}
