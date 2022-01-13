public class NumTres {
    // 96. Unique Binary Search Trees
    // https://leetcode.com/problems/unique-binary-search-trees/

    // solution from labuladong
    private int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(int lo, int hi) {
        if (lo > hi) {
            return 1;
        }

        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;

        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            res += left * right;
        }

        memo[lo][hi] = res;

        return res;
    }
}
