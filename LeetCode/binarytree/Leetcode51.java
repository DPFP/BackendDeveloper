import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

public class Leetcode51 {
    // N Queens
    // The n-queens puzzle is the problem of placing n queens on an n x n
    // chessboard such that no two queens attack each other.

    List<List<String>> results = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        // initialized matrix
        LinkedList<String> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }

        backTrack(board, 0);

        System.out.println(results);
        return results;
    }

    void backTrack(LinkedList<String> board, int row) {
        // exit condition
        if (board.size() == row) {
            results.add(new LinkedList<>(board));
            return;
        }

        int n = board.get(row).length();

        for (int col = 0; col < n; col++) {
            // check if it legal
            if (!isValid(board, row, col)) {
                continue;
            }

            // pick next step
            board.set(row, replaceChar(board.get(row), 'Q', col));

            // next level
            backTrack(board, row + 1);

            // remove last step
            board.set(row, replaceChar(board.get(row), '.', col));
        }

    }

    public String replaceChar(String str, char ch, int index) {
        return str.substring(0, index) + ch + str.substring(index + 1);
    }

    boolean isValid(LinkedList<String> board, int row, int col) {
        /* Can we place Queeon at board[row][col] */
        int n = board.size();

        // check col
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // check top right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // check top left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Leetcode51 sol = new Leetcode51();
        sol.solveNQueens(4);
    }
}
