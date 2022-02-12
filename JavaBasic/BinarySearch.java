package JavaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 2, 9, 3, 6, 8, 4, 5, 7, 1 };

        System.out.println(binarySearch(arr, 10));
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 8));

        // Other method
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, 9);
        int inde2 = Collections.binarySearch(new ArrayList<>(), 9);
        System.out.println(index);
    }

    static boolean binarySearch(int[] arr, int target) {
        Arrays.sort(arr);

        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] < target) {
                // lo = mid;
                lo = mid + 1; // have to +1, else, it will end a infinite loops if target not in range
            } else if (arr[mid] > target) {
                hi = mid;
            } else {
                System.out.println(mid);
                return true;
            }
        }
        return false;
    }

    // formal implementation
    // https://www.baeldung.com/java-binary-search
    public int runBinarySearchIteratively(int[] sortedArray, int key) {
        int index = Integer.MAX_VALUE;

        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) { // notice <= here
            // This to accommodate for extremely large arrays.
            int mid = low + ((high - low) / 2);
            // vs mid = (low + high) / 2; will easily overflow;

            if (sortedArray[mid] < key) { // right half (larger)
                low = mid + 1; // +1
            } else if (sortedArray[mid] > key) { // left hafl (smaller)
                high = mid - 1; // -1
            } else if (sortedArray[mid] == key) { // fidn the target
                index = mid;
                break;
            }
        }
        return index;
    }

    // recursive version
    public int runBinarySearchRecursively(
            int[] sortedArray, int key, int low, int high) {
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return runBinarySearchRecursively(
                    sortedArray, key, low, middle - 1);
        } else {
            return runBinarySearchRecursively(
                    sortedArray, key, middle + 1, high);
        }
    }
}
