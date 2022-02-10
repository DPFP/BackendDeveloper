public class BalancedSplit {

    // Sort: NLogN + N ==> NlogN (Complexity) Space(N)
    // inspired by this solution
    // https://leetcode.com/discuss/interview-question/718692/Facebook-or-Training-or-Balanced-Split/1022018
    boolean balancedSplitExists(int[] arr) {
        // Write your code here
        // best appraoch is to use quick sort do the calculation
        // or use two pointer from left to right after it sorted (Arrays.sort);
        int leftTotal = 0;
        int rightTotal = 0;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            rightTotal += arr[right--];
            while (left <= right && leftTotal < rightTotal) {
                leftTotal += arr[left++];
            }
        }

        if ((leftTotal + rightTotal) % 2 == 1) {
            return false;
        }

        return leftTotal == rightTotal && arr[left - 1] < arr[right + 1];
    }

    // Better solution O(N)
    // https://leetcode.com/discuss/interview-question/718692/Facebook-or-Training-or-Balanced-Split/1042923
}
