public class MaximumSubarray {
    // 53 Maximum Subarray
    // https://leetcode.com/problems/maximum-subarray/

    // great solution with explain (Similar to buy sell stock)
    // Kadane's algorithm
    // https://leetcode.com/problems/maximum-subarray/discuss/20211/Accepted-O(n)-solution-in-java
    // utlized the "preFixSum" --> find Max
    public static int maxSubArray5(int[] nums) {
        int max = nums[0];
        int localMax = nums[0];

        // notice start i = 1;
        for (int i = 1; i < nums.length; i++) {
            // localMax + nums[i] --> preFixSum
            localMax = Math.max(localMax + nums[i], nums[i]);
            max = Math.max(max, localMax);
        }

        return max;
    }

    // similar apparoch
    public int maxSubArray6(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    // solution from Labuladong (2ms - 48.2MB )
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        int[] dp = new int[len];
        dp[0] = nums[0];

        int max = Integer.MIN_VALUE;

        // 状态转移方程 (算出来 PreFixSum + nums[i] 看哪个更大)
        for (int i = 1; i < len; i++) { // notice i=1
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        // 从DP里计算出 max
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // more concise version (3ms - 90.3MB, interesting, this use much more memory)
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        int dp_0 = nums[0];
        int dp_1 = 0;

        int max = dp_0;

        // 状态转移方程 (算出来 PreFixSum + nums[i] 看哪个更大)
        for (int i = 1; i < len; i++) { // notice i=1
            // dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            dp_0 = dp_1; // previous val = current calculated;

            max = Math.max(max, dp_1);
        }

        return max;
    }

    // similar appraoch
    public int maxSubArray4(int[] A) {
        int n = A.length;

        int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];

        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0); // similar as Math.max(A[i] + 0, A[i] + dp[i-1])
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // not working solution from NeedCode
    public int maxSubArray3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 0;
        int curSum = 0;

        for (int n : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += n;
            max = Math.max(max, curSum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] t1 = { 1, 2, 3, 4 };
        int[] t1PreFixSum = new int[t1.length];

        int preFix = t1[0];
        // calculate preFixSum
        for (int i = 1; i < t1.length; i++) {
            t1PreFixSum[i] = preFix;
            preFix = preFix + t1[i];
            System.out.println(preFix);
        }

    }
}
