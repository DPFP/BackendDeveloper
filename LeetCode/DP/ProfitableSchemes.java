package LeetCode.DP;

public class ProfitableSchemes {

    // LC 879 Profitable Schemes
    // https://leetcode.com/problems/profitable-schemes/

    public int profitableSchemes(int n, int miniProfit, int[] group, int[] profit) {
        int res = 0;
        int mod = (int) 1e9 + 7;

        return res % mod;
    }

    // Lee215 sol
    public int profitableSchemes2(int G, int P, int[] group, int[] profit) {
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;

        int res = 0;
        int mod = (int) 1e9 + 7;

        for (int k = 0; k < group.length; k++) {
            int g = group[k];
            int p = profit[k];
            for (int i = P; i >= 0; i--)
                for (int j = G - g; j >= 0; j--)
                    dp[Math.min(i + p, P)][j + g] = (dp[Math.min(i + p, P)][j + g] + dp[i][j]) % mod;
        }
        for (int x : dp[P])
            res = (res + x) % mod;
        return res;
    }

    public int profitableSchemes3(int n, int miniProfit, int[] group, int[] profit) {
        int M = (int) 1e9 + 7;

        int len = group.length;

        int[][] dp = new int[n + 1][miniProfit + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 0; i < len; i++) {
            for (int j = n; j >= group[i]; j--) {
                for (int p = 0; p <= miniProfit; p++) {
                    int ind = p + profit[i] >= miniProfit ? miniProfit : p + profit[i];
                    dp[j][ind] = (dp[j][ind] + dp[j - group[i]][p]) % M;
                }
            }
        }
        return dp[n][miniProfit];
    }

    // LC Official
    public int profitableSchemes4(int G, int P, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int N = group.length;

        int[][][] dp = new int[2][P + 1][G + 1];

        dp[0][0][0] = 1;

        for (int i = 0; i < N; ++i) {
            int p0 = profit[i]; // the current crime profit
            int g0 = group[i]; // the current crime group size

            int[][] cur = dp[i % 2];
            int[][] cur2 = dp[(i + 1) % 2];

            // Deep copy cur into cur2
            for (int jp = 0; jp <= P; ++jp)
                for (int jg = 0; jg <= G; ++jg)
                    cur2[jp][jg] = cur[jp][jg];

            for (int p1 = 0; p1 <= P; ++p1) { // p1 : the current profit
                // p2 : the new profit after committing this crime
                int p2 = Math.min(p1 + p0, P);
                for (int g1 = 0; g1 <= G - g0; ++g1) { // g1 : the current group size
                    // g2 : the new group size after committing this crime
                    int g2 = g1 + g0;
                    cur2[p2][g2] += cur[p1][g1];
                    cur2[p2][g2] %= MOD;
                }
            }
        }

        // Sum all schemes with profit P and group size 0 <= g <= G.
        int ans = 0;
        for (int x : dp[N % 2][P])
            ans = (ans + x) % MOD;

        return ans;
    }
}
