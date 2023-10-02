package pg.com.ds.arrays;

import java.util.ArrayList;

public class SubsequensesSumOfK {

	public static void main(String[] args) {
		int arr[] = {10,1,2,7,6,1,5};
		int sum = 8;
        printAllSubsequence(0, arr, new ArrayList<Integer>(), sum);
	}

	private static void printAllSubsequence(int index, int arr[], ArrayList<Integer> arrayList, int sum) {
		if(index >= arr.length) {
			if(sum == 0)
				System.out.println(arrayList + " ");
			return;
		}
		
		if(arr[index]<= sum) {
			arrayList.add(arr[index]);
			printAllSubsequence(index+1, arr, arrayList, sum - arr[index]);
			arrayList.remove(arrayList.size()-1);
		}
		
		printAllSubsequence(index+1, arr, arrayList, sum);
	}

}
