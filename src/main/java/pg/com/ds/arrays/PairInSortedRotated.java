package pg.com.ds.arrays;

public class PairInSortedRotated {

	public static void main(String[] args) {
		int arr[] = {11, 15, 6, 8, 9, 10}; 
        int sum = 16; 
        int n = arr.length; 
       
        if (pairInSortedRotated(arr, n, sum)) 
            System.out.print("Array has two elements" + " with sum " + sum); 
        else
            System.out.print("Array doesn't have two" + " elements with sum " + sum); 
	}

	public static boolean pairInSortedRotated(int arr[],  int n, int x) {
		int i = 0;
		for(i = 0; i < n-1; i++) {
			if(arr[i+1] < arr[i]) {
				break;
			}
		}
		
		int low = (i+1)%n;
		int high= i;
		
		while(low != high) {
			if(arr[low]+arr[high] == x) {
				return true;
			}else if(arr[low]+arr[high] < x) {
				low = (low+1)%n;
			}else {
				high = (high-1+n)%n;
			}
		}
		return false;
	}
}
