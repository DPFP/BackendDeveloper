public class Sept9th {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
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

    public static void main(String[] args) {
        Sept9th sept9th = new Sept9th();
        int[][] mines = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 } };
        // System.out.println(sept9th.orderOfLargestPlusSign(3, mines));

        int[][] mines2 = { { 4, 2 } };
        System.out.println(sept9th.orderOfLargestPlusSign(5, mines2));
    }
}
