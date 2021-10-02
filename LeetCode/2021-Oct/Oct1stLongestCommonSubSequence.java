public class Oct1stLongestCommonSubSequence {

    public int longestCommonSubsequence(String text1, String text2) {
        // https://leetcode.com/problems/longest-common-subsequence/discuss/351689/JavaPython-3-Two-DP-codes-of-O(mn)-and-O(min(m-n))-spaces-w-picture-and-analysis
        int m = text1.length(), n = text2.length();

        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < text1.length(); ++i) {
            for (int j = 0, prevRow = 0, prevRowPrevCol = 0; j < text2.length(); ++j) {
                prevRowPrevCol = prevRow;
                prevRow = dp[j + 1];
                dp[j + 1] = text1.charAt(i) == text2.charAt(j) ? prevRowPrevCol + 1 : Math.max(dp[j], prevRow);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Oct1stLongestCommonSubSequence sol = new Oct1stLongestCommonSubSequence();

        String t1 = "baaaab";
        String t2 = "baab";

        System.out.println(sol.longestCommonSubsequence(t1, t2));
    }
}
