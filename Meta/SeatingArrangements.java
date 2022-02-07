import java.util.Arrays;

public class SeatingArrangements {

    // online solution #1
    // https://leetcode.com/discuss/interview-question/709517/Facebook-or-Recruiting-Portal-or-Seating-Arrangements/851244
    int minOverallAwkwardness(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        int len = arr.length;
        for (int i = 2; i < len; i += 2) {
            diff = Math.max(diff, arr[i] - arr[i - 2]);
        }

        for (int i = 3; i < len; i += 2) {
            diff = Math.max(diff, arr[i] - arr[i - 2]);
        }

        return Math.max(diff, arr[len - 1] - arr[len - 2]);
    }

    // online solution #2
    // good explaintion
    // https://leetcode.com/discuss/interview-question/709517/Facebook-or-Recruiting-Portal-or-Seating-Arrangements/696844
    int minOverallAwkwardness2(int[] arr) {
        // Write your code here
        Arrays.sort(arr);

        int n = arr.length;

        int diff = arr[1] - arr[0]; // special case

        for (int i = 2; i < n; i++) {
            diff = Math.max(diff, arr[i] - arr[i - 2]);
        }

        return Math.max(diff, arr[n - 1] - arr[n - 2]); // special case
    }
}
