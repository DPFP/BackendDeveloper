import java.util.LinkedList;
import java.util.Queue;

public class BFSMatrix {

    static boolean isValid(boolean vis[][], int row, int rowBound, int col, int colBound) {
        // If cell lies out of bounds
        if (row < 0 || col < 0 || row >= rowBound || col >= colBound)
            return false;

        // If cell is already visited
        if (vis[row][col])
            return false;

        // Otherwise
        return true;
    }

    static void BFS(int grid[][], boolean visited[][], int row, int col) {
        // Direction vectors
        // (-1,0) up; (0,1) right; (1,0) down; (0,-1) left
        int dRow[] = { -1, 0, 1, 0 };
        int dCol[] = { 0, 1, 0, -1 };

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Pair cell = q.poll();
            int x = cell.first;
            int y = cell.second;

            System.out.print(grid[x][y] + " ");

            // go to adjacent cells - check for direction
            for (int i = 0; i < 4; i++) { // has to be 4 --> four direction
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];

                if (isValid(visited, adjx, grid.length, adjy, grid[0].length)) {
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
        boolean[][] vis = new boolean[grid.length][grid[0].length];

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