public class Sept26thTransformChesseboard {

    public int movesToChessboard(int[][] board) {
        // https://www.cnblogs.com/grandyang/p/9053705.html
        // https://massivealgorithms.blogspot.com/2019/03/leetcode-782-transform-to-chessboard.html
        int N = board.length, colToMove = 0, rowToMove = 0, rowOneCnt = 0, colOneCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (((board[0][0] ^ board[i][0]) ^ (board[i][j] ^ board[0][j])) == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            rowOneCnt += board[0][i];
            colOneCnt += board[i][0];
            if (board[i][0] == i % 2) {
                rowToMove++;
            }
            if (board[0][i] == i % 2) {
                colToMove++;
            }
        }
        if (rowOneCnt < N / 2 || rowOneCnt > (N + 1) / 2) {
            return -1;
        }
        if (colOneCnt < N / 2 || colOneCnt > (N + 1) / 2) {
            return -1;
        }
        if (N % 2 == 1) {
            // we cannot make it when ..ToMove is odd
            if (colToMove % 2 == 1) {
                colToMove = N - colToMove;
            }
            if (rowToMove % 2 == 1) {
                rowToMove = N - rowToMove;
            }
        } else {
            colToMove = Math.min(colToMove, N - colToMove);
            rowToMove = Math.min(rowToMove, N - rowToMove);
        }
        return (colToMove + rowToMove) / 2;
    }

    public static void main(String[] args) {
        Sept26thTransformChesseboard sol = new Sept26thTransformChesseboard();
        int[][] board = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 } };
        System.out.println(sol.movesToChessboard(board));
    }
}