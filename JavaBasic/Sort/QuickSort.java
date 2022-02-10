package Sort;

import java.util.Arrays;

public class QuickSort {

    // Tutorial https://www.baeldung.com/java-quicksort (took 15 mins to learn)
    // This video explained the best https://www.youtube.com/watch?v=0SkOjNaO1XY
    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            // We get the index of the sorted pivot and use it
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    // this function takes the last element as the pivot.
    // this is the core for quick sort
    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];

        int i = (begin - 1); // why need - 1 ? //left wall

        // separate the arr to two group
        // 1st : 0 -- i (will be smllaer than pivot)
        // 2nd : i + 1 -- end (will be greather than pivot);
        for (int j = begin; j < end; j++) {
            // if smaller, move up the left pointer (i) and swap
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        // put the pivot value into the middle
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        // index of pivot
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 9, 4, 6, 5, 3 };
        quickSort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
    }
}
