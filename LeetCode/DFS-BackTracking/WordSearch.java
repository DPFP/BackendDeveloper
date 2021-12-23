public class WordSearch {

    boolean[][] visited;
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // right, down, left, up
    int row, col;

    // Solution:
    // https://leetcode.com/problems/word-search/discuss/27811/My-Java-solution/187889
    public boolean exist(char[][] board, String word) {
        // special case -- m0 -- missing board is null
        if (board == null || board.length <= 0 || board[0].length <= 0) {
            return false;
        }

        row = board.length; // m
        col = board[0].length; // n

        // M1 (mistake 1) forget to initilized the visisted
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // if(search(board, i, j, 0, word)){
                // m2 - the condition should be the following
                if (search(board, visited, i, j, 0, word))
                    return true;
            }
        }
        // if not possible
        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, int ri, int ci, int i, String word) {

        // means have found the word
        if (i == word.length()) {
            return true;
        }

        // set up the boundaries;
        // M - it should be ri >= row (missing the =)
        if (ri < 0 || ri >= row || ci < 0 || ci >= col) {
            return false;
        }

        // already visited;
        if (visited[ri][ci]) {
            return false;
        }

        // dead end -- return
        if (board[ri][ci] != word.charAt(i)) {
            return false;
        }

        // it is a match -- mark it visited
        visited[ri][ci] = true;

        // check surrounding four direction --> DFS
        for (int[] dir : dirs) {
            int n_ri = ri + dir[0];
            int n_ci = ci + dir[1];
            // DFS check if next character if match or not
            // if match, return true to above stack call
            if (search(board, visited, n_ri, n_ci, i + 1, word)) {
                return true;
            }
        }
        // backtracking if the previous step failed, basically take one step back
        visited[ri][ci] = false;

        return false;

    }

    public static void main(String[] args) {
        WordSearch sol = new WordSearch();
        sol.exist(null, null);
    }
}