package sequences;

public class MaximumProductSubarray {
    // 152 Maximum Product Subarray
    // https://leetcode.com/problems/maximum-product-subarray/

    // solution from discussion, worked
    // https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity/248020
    // Good explain
    // https://leetcode.com/problems/maximum-product-subarray/discuss/48302/2-Passes-scan-beats-99
    public int maxProduct3(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;

        int prod = 1; // (pre/post)fix-product
        for (int i = 0; i < len; i++) {
            prod = prod * nums[i];
            res = Math.max(res, prod); // compare self with (pre)FixProduct
            if (prod == 0) {
                prod = 1;
            }
        }

        // reset the prod
        prod = 1;
        // calculate the (post)FixProduct
        for (int i = len - 1; i >= 0; i--) {
            prod = prod * nums[i];
            res = Math.max(res, prod);
            if (prod == 0) {
                prod = 1;
            }
        }

        return res;
    }

    // first try didn't work.
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int localMax = nums[0];

        int len = nums.length;

        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                localMax = Math.max(nums[i], nums[i] * localMax);
                max = Math.max(max, localMax);
            } else if (nums[i] < 0) {

            } else { // nums[i] == 0

            }
        }

        return max;
    }

    // solution from discussion -- didn't work
    public int maxProduct2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];

        int localMax;
        int localMin;

        int len = nums.length;

        for (int i = 1; i < len; i++) {
            localMax = max;
            localMin = max;

            if (nums[i] < 0) {
                int temp = localMin;
                localMin = localMax;
                localMax = temp;
            }

            localMax = Math.max(nums[i], nums[i] * localMax);
            localMin = Math.min(nums[i], nums[i] * localMin);

            max = Math.max(max, localMax);

        }

        return max;
    }
}
