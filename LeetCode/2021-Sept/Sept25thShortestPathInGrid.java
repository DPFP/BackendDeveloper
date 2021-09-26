import java.util.LinkedList;
import java.util.Queue;

public class Sept25thShortestPathInGrid {
    public int shortestPath(int[][] grid, int k) {
        final int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        final int rowLength = grid.length;
        final int colLength = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[rowLength][colLength][k + 1];
        visited[0][0][0] = true;
        queue.offer(new int[] { 0, 0, 0 });
        int minSteps = 0;

        while (!queue.isEmpty()) {
            final int size = queue.size();

            for (int i = 0; i < size; i++) {
                final int[] info = queue.poll();
                final int row = info[0];
                final int col = info[1];
                final int currObstacble = info[2];

                if (row == rowLength - 1 && col == colLength - 1) {
                    return minSteps;
                }

                for (int[] direction : directions) {
                    final int nextRow = direction[0] + row;
                    final int nextCol = direction[1] + col;
                    int nextObstacle = currObstacble;

                    if (nextRow > -1 && nextRow < rowLength && nextCol > -1 && nextCol < colLength) {
                        if (grid[nextRow][nextCol] == 1) {
                            nextObstacle++;
                        }

                        if (nextObstacle <= k && !visited[nextRow][nextCol][nextObstacle]) {
                            visited[nextRow][nextCol][nextObstacle] = true;
                            queue.offer(new int[] { nextRow, nextCol, nextObstacle });
                        }
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Sept25thShortestPathInGrid sol = new Sept25thShortestPathInGrid();
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };

        System.out.println(sol.shortestPath(grid, 1));
    }
}
