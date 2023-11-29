package pg.com.ds.arrays;

import java.util.Arrays;

public class WaveArray {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 2, 5};

        System.out.println("Original Array: " + Arrays.toString(arr));

        arrangeInWave(arr);

        System.out.println("Wave Array: " + Arrays.toString(arr));
        int[] arr1 = {3, 1, 4, 2, 2, 5};
        
        sortInWave(arr, arr.length);

        System.out.println("Wave Array: " + Arrays.toString(arr1));
        
    }

    public static void arrangeInWave(int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        // Swap adjacent elements to create the wave pattern
        for (int i = 0; i < arr.length - 1; i += 2) {
            swap(arr, i, i + 1);
        }
    }
    
    // This function sorts arr[0..n-1] in wave form, i.e., arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4].... 
    static void sortInWave(int arr[], int n) 
    { 
        // Traverse all even elements 
        for (int i = 0; i < n; i+=2) 
        { 
            // If current even element is smaller 
            // than previous 
            if (i>0 && arr[i-1] > arr[i] ) 
                swap(arr, i-1, i); 
  
            // If current even element is smaller 
            // than next 
            if (i<n-1 && arr[i] < arr[i+1] ) 
                swap(arr, i, i + 1); 
        } 
    } 
    

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

