import java.util.LinkedList;
import java.util.List;

import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

public class Leetcode51 {
    // N Queens
    // The n-queens puzzle is the problem of placing n queens on an n x n
    // chessboard such that no two queens attack each other.

    List<List<String>> results = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        LinkedList<String> track = new LinkedList<>();

        // initialized matrix
        List<String> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            result.add(sb.toString());
        }
        results.add(result);
        //

        backTrack(track, n);

        System.out.println(results);
        return results;
    }

    void backTrack(LinkedList<String> track, int n) {
        // exit condition
        if (track.size() == n) {
            results.add(new LinkedList<>(track));
            return;
        }

        // ???
        for (int i = 0; i < n; i++) {
            // check if it legal
            if (isValid()) {
                // do something
            }

            // pick next step

            // next level
            backTrack(track, n);

            // remove last step
            track.removeLast();

        }

    }

    boolean isValid() {

        return false;
    }

    public static void main(String[] args) {
        Leetcode51 sol = new Leetcode51();
        sol.solveNQueens(4);
    }
}
