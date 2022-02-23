package JavaBasic.OOD.GameOfLife;

public class Board {

    private int row;
    private int col;
    private int[][] board;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new int[row][col];
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue(int r, int c){
        return board[r][c];
    }

    public void setValue(int r, int c, int value){
        board[r][c] = value;
    }
}
