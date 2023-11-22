package pg.com.ds.arrays;

public class QuickSortImpl {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; // Nothing to sort
        }

        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the partition index such that elements smaller than the pivot
            // are on the left and elements greater than the pivot are on the right
            int partitionIndex = partition(arr, low, high);

            // Recursively sort the sub-arrays
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1; // Return the partition index
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

        // Perform QuickSort
        quickSort(array);

        System.out.println("Array after QuickSort:");
        printArray(array);
    }
}
