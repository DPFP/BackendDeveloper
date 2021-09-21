public class Sept20thTicTacToe {
    public String tictactoe(int[][] moves) {
        String res = new String();
        int[][] board = new int[3][3];

        // winning condition: 3 in a row (horizontal, vertical, or diagonal)
        // Draw condition: 9 moves
        // Pending condition: no winner and no draw
        // outcome: A, B, Draw, Pending

        // input -- fill the boards
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            board[x][y] = i % 2 == 0 ? 1 : 2;
        }

        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 1) {
                    res = "A";
                } else if (board[i][0] == 2) {
                    res = "B";
                }
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 1) {
                    res = "A";
                } else if (board[0][i] == 2) {
                    res = "B";
                }
            }
        }

        // check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 1) {
                res = "A";
            } else if (board[0][0] == 2) {
                res = "B";
            }
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 1) {
                res = "A";
            } else if (board[0][2] == 2) {
                res = "B";
            }
        }

        // check draw & Pending condition
        if (res.equals("")) {
            if (moves.length == 9) {
                res = "Draw";
            } else {
                res = "Pending";
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Sept20thTicTacToe t = new Sept20thTicTacToe();
        int[][] moves = { { 0, 0 }, { 2, 0 }, { 1, 1 }, { 2, 1 }, { 2, 2 } };
        System.out.println(t.tictactoe(moves));

    }
}
