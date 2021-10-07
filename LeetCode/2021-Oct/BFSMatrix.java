import java.util.LinkedList;
import java.util.Queue;

public class BFSMatrix {
    static final int ROW = 4;
    static final int COL = 4;

    // Direction vectors
    // (-1,0) up; (0,1) right; (1,0) down; (0,-1) left
    static int dRow[] = { -1, 0, 1, 0 };
    static int dCol[] = { 0, 1, 0, -1 };

    static boolean isValid(boolean vis[][], int row, int col) {
        // If cell lies out of bounds
        if (row < 0 || col < 0 || row >= ROW || col >= COL)
            return false;

        // If cell is already visited
        if (vis[row][col])
            return false;

        // Otherwise
        return true;
    }

    static void BFS(int grid[][], boolean visited[][], int row, int col) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Pair cell = q.peek();
            int x = cell.first;
            int y = cell.second;

            System.out.print(grid[x][y] + " ");

            q.remove();

            // go to adjacent cells - check for direction
            for (int i = 0; i < 4; i++) { // has to be 4 --> four direction
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];

                if (isValid(visited, adjx, adjy)) {
                    q.add(new Pair(adjx, adjy));
                    visited[adjx][adjy] = true;
                }

            }
        }
    }

    public static void main(String[] args) {
        // Given input matrix
        int grid[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        // Declare the visited array
        boolean[][] vis = new boolean[ROW][COL];

        BFS(grid, vis, 0, 0);
    }
}

class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}