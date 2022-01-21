public class SurroundedRegions {

    // 130. Surrounded Regions
    // https://leetcode.com/problems/surrounded-regions/
    // this solution is very similar to 417
    int[][] DIRS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        // dfs search from four borders -- makr as O. every other place which was not
        // marked O will be replaced with X
        int NROW = board.length;
        int NCOL = board[0].length;

        boolean[][] markO = new boolean[NROW][NCOL];

        // check left, right most
        for (int r = 0; r < NROW; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, markO, board);
            }
            if (board[r][NCOL - 1] == 'O') {
                dfs(r, NCOL - 1, markO, board);
            }
        }

        // check top, bottom most
        for (int c = 0; c < NCOL; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, markO, board);
            }
            if (board[NROW - 1][c] == 'O') {
                dfs(NROW - 1, c, markO, board);
            }

        }

        // cross-reference check & flip the value
        for (int r = 0; r < NROW; r++) {
            for (int c = 0; c < NCOL; c++) {
                if (markO[r][c]) {
                    board[r][c] = 'O';
                } else {
                    board[r][c] = 'X';
                }
            }
        }

    }

    private void dfs(int row, int col, boolean[][] mark, char[][] board) {
        mark[row][col] = true;

        for (int[] dir : DIRS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }

            if (mark[newRow][newCol]) {
                continue;
            }

            // if it not O
            if (board[newRow][newCol] != board[row][col]) {
                continue;
            }

            dfs(newRow, newCol, mark, board);
        }
    }
}
