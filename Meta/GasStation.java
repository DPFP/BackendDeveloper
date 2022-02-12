package Meta;

public class GasStation {

    // 134 Gas Station https://leetcode.com/problems/gas-station/

    // labuladong solution NO.1 -- with graph
    // https://labuladong.gitee.io/algo/3/27/108/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0;
        int minSum = 0; // 相当于图像中的坐标点和最低点
        int start = 0;

        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                // 经过第 i 个站点后，使 sum 到达新低
                // 所以站点 i + 1 就是最低点（起点）
                start = i + 1;
                minSum = sum;
            }
        }
        // no way we will make it
        if (sum < 0) {
            return -1;
        }
        // since we are dealing with loop
        return start == len ? 0 : start;
    }

    // Greedy algorithm
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0;

        int tank = 0;
        int start = 0;

        // first pass -- check if it even possible
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i]; // the order doesn't matter here
        }
        if (sum < 0) {
            return -1;
        }

        // 2nd pass - at this point, we know there is possible to make it
        for (int i = 0; i < len; i++) {
            // keep update the the tank status.
            tank += gas[i] - cost[i];
            // is it possible to next station ? If yes, keep going.
            // if not, pick a new starting point
            if (tank < 0) {
                // 无法从 start 走到 i 所以站点 i + 1 应该是起点
                tank = 0; // reset tank
                start = i + 1;
            }
        }

        // since we are dealing with loop
        return start == len ? 0 : start;
    }
}
