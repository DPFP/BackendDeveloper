package JavaBasic;

import java.util.Arrays;

public class BSPractice {

    private static int binarySearch(int[] arr, int target) {
        int res = -1;

        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target < arr[mid]) {
                right = mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
            System.out.println("calculate: " + ++count);
        }

        return res;
    }

    public static void main(String[] args) {
        // notice the arr is already sorted.
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        // if is not sorted, we cal always do
        Arrays.sort(arr); // and then do binarySearch

        System.out.println(binarySearch(arr, 2)); // 1
        System.out.println(binarySearch(arr, 6)); // 5
    }
}
