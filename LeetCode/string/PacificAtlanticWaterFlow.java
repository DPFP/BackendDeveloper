import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {
    // 417 Pacific Atlantic Water Flow
    // https://leetcode.com/problems/pacific-atlantic-water-flow/

    // not working try
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // right, down, left, up

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // bounaries
        // pacific will be {-1, X}(up) & {X, -1}(left);
        // Atlantic will be {X, C.len + 1}(right) & {R.len + 1, X}(down)
        // if there is a path to any of those bounries ?
        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights.length; c++) {
                System.out.print(heights[r][c] + " ");
                // check if it able to flow to both ocean ?
                if (DFS(heights, r, c)) {
                    // res.add(Arrays.asList({r,c}));
                    System.out.println("got it: " + r + " " + c);
                }
            }
            System.out.println();
        }

        return res;
    }

    private boolean DFS(int[][] heights, int r, int c) {
        // need check four direction to see if there is a path to both ocen
        boolean res = false;

        // if reach pacific
        if (r == -1 || c == -1) {
            res = true;
        } else {
            res = false;
        }

        // if reach atlantic
        if (c == heights[0].length + 1 || r == heights.length + 1) {
            res = true;
        } else {
            res = false;
        }

        // if is at the bounary --> return; ? why there is "=>" for the upper bounary ?
        if (r < 0 || r >= heights.length - 1 || c < 0 || c >= heights[0].length - 1) {
            return res;
        }

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nr >= heights.length - 1 || nc < 0 || nc >= heights[0].length - 1) {
                if (heights[r][c] >= heights[nr][nc]) {
                    res = DFS(heights, r + dir[0], c + dir[1]);
                }
            }
        }

        return res;
    }

    // Unfinished solution
    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
        int nr = heights.length;
        int nc = heights[0].length;

        Set<int[]> pac = new HashSet<>();
        Set<int[]> alt = new HashSet<>();

        List<List<Integer>> res = new ArrayList<>();

        for (int c = 0; c < nc; c++) {
            DFS(0, c, pac, heights[0][c]);
            DFS(nr - 1, c, alt, heights[nr - 1][c]);
        }

        for (int r = 0; r < nr; r++) {
            DFS(r, 0, pac, heights[r][0]);
            DFS(r, nc - 1, alt, heights[r][nc - 1]);
        }

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                int[] cur = { r, c };
                // this not gonna work
                if (pac.contains(cur) && alt.contains(cur)) {

                }
            }
        }

        return res;
    }

    private void DFS(int r, int c, Set<int[]> visit, int prevHeight) {

    }

    // ---------------------LC solution
    private static final int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    private int numRows;
    private int numCols;
    private int[][] landHeights;

    public List<List<Integer>> pacificAtlantic3(int[][] heights) {
        // Check if input is empty
        if (heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        // Save initial values to parameters
        numRows = heights.length;
        numCols = heights[0].length;

        landHeights = heights;
        boolean[][] pacificReachable = new boolean[numRows][numCols];
        boolean[][] atlanticReachable = new boolean[numRows][numCols];

        // Loop through each cell adjacent to the oceans and start a DFS
        for (int i = 0; i < numRows; i++) {
            dfs(i, 0, pacificReachable);
            dfs(i, numCols - 1, atlanticReachable);
        }

        for (int i = 0; i < numCols; i++) {
            dfs(0, i, pacificReachable);
            dfs(numRows - 1, i, atlanticReachable);
        }

        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }

    private void dfs(int row, int col, boolean[][] reachable) {
        // This cell is reachable, so mark it
        reachable[row][col] = true;

        for (int[] dir : DIRECTIONS) { // Check all 4 directions
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Check if new cell is within bounds
            if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                continue;
            }

            // Check that the new cell hasn't already been visited
            if (reachable[newRow][newCol]) {
                continue;
            }

            // Check that the new cell has a higher or equal height,
            // So that water can flow from the new cell to the old cell
            if (landHeights[newRow][newCol] < landHeights[row][col]) {
                continue;
            }

            // If we've gotten this far, that means the new cell is reachable
            dfs(newRow, newCol, reachable);
        }
    }

    public static void main(String[] args) {
        int[] cur = { 1, 2 };

        Set<int[]> test = new HashSet<>();
        test.add(new int[] { 1, 2 });

        if (test.contains(cur)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
