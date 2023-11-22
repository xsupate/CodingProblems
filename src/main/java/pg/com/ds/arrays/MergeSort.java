package pg.com.ds.arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }

        int n = arr.length;
        int[] temp = new int[n];
        mergeSort(arr, temp, 0, n - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the left and right halves
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);

            // Merge the sorted halves
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy data to temporary arrays
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left; // Initial index of the first subarray
        int j = mid + 1; // Initial index of the second subarray
        int k = left; // Initial index of the merged subarray

        // Merge the two halves back into the original array
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy the remaining elements of the left subarray, if any
        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        // Copy the remaining elements of the right subarray, if any
        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array:");
        printArray(array);

        // Perform Merge Sort
        mergeSort(array);

        System.out.println("Array after Merge Sort:");
        printArray(array);
    }
}

