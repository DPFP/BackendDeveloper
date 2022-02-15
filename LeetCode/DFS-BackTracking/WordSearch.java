public class WordSearch {

    // 79. Word Search	
    // https://leetcode.com/problems/word-search/
    // PD: 10/07/21, 12/22/21,12/25/21, 2/14/22

    int row, col;
    boolean[][] visited;
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // right - down - left - up

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        row = board.length;
        col = board[0].length;

        visited = new boolean[row][col];

        // how could i missed the for loop
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (search(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, int ir, int ic, int d, String word) {
        if (d == word.length()) {
            return true;
        }

        // out of boundries
        // this bounary check must before visited[][] check, otherwise out of bounry
        // exception
        // alsoe make sure ir >= row, and ic >= col !!!
        if (ir < 0 || ir >= row || ic < 0 || ic >= col || visited[ir][ic]) {
            return false;
        }

        // not match
        if (board[ir][ic] != word.charAt(d)) {
            return false;
        }

        visited[ir][ic] = true;

        for (int[] dir : dirs) {
            int tr = ir + dir[0];
            int tc = ic + dir[1];
            if (search(board, tr, tc, d + 1, word)) {
                return true;
            }
        }

        visited[ir][ic] = false;

        return false;
    }

    public static void main(String[] args) {
        WordSearch sol = new WordSearch();
        sol.exist(null, null);
    }
}