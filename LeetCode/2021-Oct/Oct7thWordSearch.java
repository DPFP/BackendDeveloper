import java.util.LinkedList;
import java.util.Queue;

public class Oct7thWordSearch {

    public boolean exist(char[][] board, String word) {
        boolean res = false;

        // 1, find the starting point/ starting letter
        int[] start = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    System.out.println("find the start:" + i + " " + j);
                    start[0] = i;
                    start[1] = j;
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    // could be more than one start point
                    if (BFS(board, visited, start[0], start[1], word)) {
                        return true;
                    }
                } // else don't even try;
            }
        }
        return res;
    }

    boolean isValid(boolean vis[][], int row, int rowBound, int col, int colBound) {
        // If cell lies out of bounds
        if (row < 0 || col < 0 || row >= rowBound || col >= colBound)
            return false;

        // If cell is already visited
        if (vis[row][col])
            return false;

        // Otherwise
        return true;
    }

    boolean BFS(char grid[][], boolean visited[][], int row, int col, String word) {
        int dRow[] = { -1, 0, 1, 0 };
        int dCol[] = { 0, 1, 0, -1 };

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));
        visited[row][col] = true;

        int count = 1; // first letter confirmed;

        while (!q.isEmpty() && count < word.length()) {
            Pair curCell = q.poll();
            int x = curCell.first;
            int y = curCell.second;

            System.out.print(grid[x][y] + " ");
            // word.charAt(count) == grid[adjx][adjy]

            first: for (int i = 0; i < 4; i++) {
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];

                // 2, check surranding with next letter, if not return false, if yes, keep going
                if (isValid(visited, adjx, grid.length, adjy, grid[0].length)) {
                    visited[adjx][adjy] = true;
                    if (word.charAt(count) == grid[adjx][adjy]) {
                        q.add(new Pair(adjx, adjy));
                        count++;
                        break first; // can't break because SE/ SEE
                    }
                }
            }
        }

        System.out.println(count);
        if (count == word.length()) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Oct7thWordSearch sol = new Oct7thWordSearch();
        // Given input matrix

        char t1[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        char t2[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        // Declare the visited array

        // System.out.println(sol.exist(t1, "ABCCED"));
        System.out.println(sol.exist(t2, "SEE"));
    }
}