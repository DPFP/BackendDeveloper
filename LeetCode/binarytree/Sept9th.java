import java.util.Arrays;

public class Sept9th {

    public int orderOfLargestPlusSign2(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = -1; // -1 means mine
        }
        int max = 0;
        for (int i = 0; i < n; i++) { // row
            for (int j = 0; j < n; j++) { // col
                if (grid[i][j] == 0) { // if not mine
                    int left = j; // left boundary
                    while (left >= 0 && grid[i][left] == 0) {
                        left--;
                    }
                    int right = j; // right boundary
                    while (right < n && grid[i][right] == 0) {
                        right++;
                    }
                    int up = i; // up boundary
                    while (up >= 0 && grid[up][j] == 0) {
                        up--;
                    }
                    int down = i; // down boundary
                    while (down < n && grid[down][j] == 0) {
                        down++;
                    }
                    int size = (right - left + 1) * (down - up + 1); // size of the plus sign
                    max = Math.max(max, size); // update max
                }
            }
        }
        return max;
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], n);
        }

        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1, l = 0, r = 0, u = 0, d = 0; j < n; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1)); // left
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1)); // right
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1)); // up
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1)); // down
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // LeetCode Blog post
        // https://massivealgorithms.blogspot.com/2018/04/leetcode-764-largest-plus-sign.html

        Sept9th sept9th = new Sept9th();
        int[][] mines = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 } };
        // System.out.println(sept9th.orderOfLargestPlusSign(3, mines));

        int[][] mines2 = { { 4, 2 } };
        System.out.println(sept9th.orderOfLargestPlusSign(5, mines2));
    }
}
