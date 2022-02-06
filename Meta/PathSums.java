import java.util.Arrays;
import java.util.HashMap;

public class PathSums {

    // BF solution O(n^2)
    int numberOfWays(int[] arr, int k) {
        // Write your code here
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (k - arr[i] == arr[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    // if O(n log n) is the best we can do. Solutions with this runtime typically
    // involve binary search, sorting, or divide and conquer. It may be necessary to
    // use additional space to improve the time complexity.

    // Use two pointer, but this can't handle duplicated element within arr e.g.
    // [1,2,2,3,3,4]
    // To handle duplicate element(s):
    // we can consider each [block of the same value as a single index] in the
    // array,
    // but with a “weight” equal to the number of occurrences of that value.
    int numberOfWays2(int[] arr, int k) {
        // first sort the array
        Arrays.sort(arr);

        // then using two pointer, we don't care about the pair(indexes), we just need
        // the count;
        int counter = 0;

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] + arr[end] < k) {
                start++;
            } else if (arr[start] + arr[end] > k) {
                end--;
            } else {
                counter++;
                start++;
                end--;
            }
        }

        return counter;
    }

    // TODO O(N) appraoch
    int numberOfWays3(int[] arr, int k) {
        // Write your code here
        // O(n) appraoch
        // Key: value, Value: freq
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int n : arr) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        int counter = 0;

        for (int key : freqMap.keySet()) {
            // n = k/2
            int weight = freqMap.get(k - key); // could be null ?
            if (weight > 1) {
                counter = counter + weight;
            } else {

            }
        }

        return counter;
    }
}
