package JavaBasic.OOD.RobotGame;

import JavaBasic.OOD.GameOfLife.ConsoleColors;

public class Board {
    private final int row;
    private final int col;
    private int[][] board;
    private Robot robot;
    private static Board instance;


    private Board(int row, int col, Robot robot) {
        this.row = row;
        this.col = col;
        this.board = new int[row][col];
        this.robot = robot;
    }

    public static Board getInstance(int row, int col, Robot robot){
        if(instance == null){
            instance = new Board(row,col,robot);
        }
        return instance;
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
                    System.out.print(ConsoleColors.RED_BACKGROUND + "R " + ConsoleColors.RESET);
                } else {
//                    System.out.print(board[r][c] + "(" + r + "," + c + ") ");
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + board[r][c] + " " + ConsoleColors.RESET);
                }

            }

            System.out.println();
        }
    }
}
