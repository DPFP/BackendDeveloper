package JavaBasic.OOD.RobotGame;

public class Board {
    private int row;
    private int col;
    private int[][] board;
    private Robot robot;

    //TODO
    // Make this singleton class

    public Board(int row, int col, Robot robot) {
        this.row = row;
        this.col = col;
        this.board = new int[row][col];
        this.robot = robot;
    }

    //Do we really need this ?
    public void clear() {
        System.out.println("clear board -- reset robot");
        this.board = new int[row][col];
        this.robot = null;
    }

    public void status() {
        System.out.println();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                Position cur = this.robot.getPosition();
                if (cur.getX() == r && cur.getY() == c) {
                    System.out.print("R ");
                } else {
//                    System.out.print(board[r][c] + "(" + r + "," + c + ") ");
                    System.out.print(board[r][c] + " ");
                }

            }

            System.out.println();
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

}
