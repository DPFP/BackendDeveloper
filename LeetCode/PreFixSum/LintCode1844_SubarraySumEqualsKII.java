import java.util.HashMap;

public class LintCode1844_SubarraySumEqualsKII {
    /**
     * @param nums: a list of integer
     * @param k:    an integer
     * @return: return an integer, denote the minimum length of continuous subarrays
     *          whose sum equals to k https://www.lintcode.com/problem/1844/
     */

    public int subarraySumEqualsKII(int[] nums, int k) {
        // key: preFixSum; value: preFixSumIndex (K is the target --> Key)
        HashMap<Long, Integer> sumToIndexMap = new HashMap<>();
        sumToIndexMap.put((long) 0, 0);

        long prefixSum = 0; // prefixSum[0] = 0
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // find preFixSum from zero to current location;
            prefixSum = prefixSum + (long) nums[i];

            if (sumToIndexMap.containsKey(prefixSum - k)) {
                int len = i + 1 - sumToIndexMap.get(prefixSum - k);

                answer = Math.min(answer, len);
            }
            sumToIndexMap.put(prefixSum, i + 1);
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    // separate method to calculate the preFixSum
    public int[] preFixSum(int[] nums) {
        int[] preFixSum = new int[nums.length + 1];
        preFixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preFixSum[i + 1] = preFixSum[i] + nums[i];
        }
        return preFixSum;
    }

    public static void main(String[] args) {
        int[] t1 = { 1, 1, 1, 2 };
        int[] t2 = { 2, 1, -1, 4, 2, -3 };
        LintCode1844_SubarraySumEqualsKII sol = new LintCode1844_SubarraySumEqualsKII();

        System.out.println(sol.subarraySumEqualsKII(t1, 3)); // 2

        System.out.println(sol.subarraySumEqualsKII(t2, 3)); // 2

    }
}