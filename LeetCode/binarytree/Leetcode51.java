import java.util.LinkedList;
import java.util.List;

public class Leetcode51 {
    // N Queens
    // The n-queens puzzle is the problem of placing n queens on an n x n
    // chessboard such that no two queens attack each other.

    List<List<String>> result = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> track = new LinkedList<>();

        // initialized result
        for (int i = 0; i < n; i++) {
            List<String> dots = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                dots.add(".");
            }
            result.add(dots);
        }

        System.out.println(result);
        return result;
    }

    void backTrack(List<String> track, int n) {

    }

    boolean isValid() {

        return false;
    }

    public static void main(String[] args) {
        Leetcode51 sol = new Leetcode51();
        sol.solveNQueens(4);
    }
}
