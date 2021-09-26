public class Sept19thDistinctSubsequences {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1]; // dp[i][j] means the number of distinct subsequences of
                                                              // s[0:i] and t[0:j]
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1; // empty string is a subsequence of any string
        }
        for (int i = 1; i <= s.length(); i++) { // i is the index of s
            for (int j = 1; j <= t.length(); j++) { // j is the index of t
                if (s.charAt(i - 1) == t.charAt(j - 1)) { // if the last char of s and t are the same
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()]; // the last element of dp is the answer
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        Sept19thDistinctSubsequences obj = new Sept19thDistinctSubsequences();
        System.out.println(obj.numDistinct(s, t));
    }
}
