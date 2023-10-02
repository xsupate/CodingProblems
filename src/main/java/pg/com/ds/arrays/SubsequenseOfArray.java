package pg.com.ds.arrays;

import java.util.ArrayList;

public class SubsequenseOfArray {
	public static void main(String args[]) {
        int arr[] = {1,2,3};
        printAllSubsequence(0, arr, new ArrayList<Integer>());
	}

	private static void printAllSubsequence(int index, int arr[], ArrayList<Integer> arrayList) {
		if(index >= arr.length) {
			System.out.print(arrayList + " ");
			return;
		}
		
		arrayList.add(arr[index]);
		printAllSubsequence(index+1, arr, arrayList);
		arrayList.remove(arrayList.size()-1);
		printAllSubsequence(index+1, arr, arrayList);
	}
	
	
}
