public class ChangeinaForeignCurrency {

    // first try didn't work -- stackvoerflow
    boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        // DFS + backtracking

        if (targetMoney == 0) {
            return true;
        }

        for (int denomination : denominations) {
            return dfs(targetMoney, denomination);
        }

        return false;
    }

    boolean dfs(int t, int d) {
        if (t == 0) {
            return true;
        }

        t = t - d;
        dfs(t, d);
        t = t + d;

        return false;
    }

    // 2nd try with reference solution
    // https://leetcode.com/discuss/interview-question/999637/Facebook-or-Online-or-Change-in-a-Foreign-Currency/808099
    // this actually easier version than https://leetcode.com/problems/coin-change/
    boolean canGetExactChange2(int targetMoney, int[] denominations) {
        // Write your code here
        // DFS + backtracking

        // missing this part
        if (targetMoney < 0) {
            return false;
        }

        if (targetMoney == 0) {
            return true;
        }

        for (int denomination : denominations) {
            if (canGetExactChange(targetMoney - denomination, denominations)) {
                return true;
            }
        }

        return false;
    }

}
