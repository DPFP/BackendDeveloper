package JavaBasic.OOD.GameOfLife;

public class GameOfLife {
    private Board board;
    private int ROW;
    private int COL;

    public GameOfLife(int row, int col) {
        this.ROW = row;
        this.COL = col;
        this.board = new Board(row, col);
    }

    public void initialBoard() {
        //set random live with 1;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                int random = (int) (Math.random() * 3) + 1;
                ; //  every 1/4 will be live
                if (random == 3) {
                    board.setValue(r, c, 1);
                }
            }
        }
    }

    public void displayBoard() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if(board.getValue(r,c) == 1){
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + board.getValue(r, c) + " " + ConsoleColors.RESET);
                }else{
                    System.out.print(ConsoleColors.RED_BACKGROUND + board.getValue(r, c) + " " + ConsoleColors.RESET);
                }

            }
            System.out.println();
        }
    }

    public void calculateNextGeneration() {
        Board nextBoard = copyBoard(board);
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                int liveNeighbors = countliveNeighbors(r, c, board);
                if (board.getValue(r,c) == 0) {
                    if (liveNeighbors == 3){
                        nextBoard.setValue(r,c,1);
                    }
                } else if (board.getValue(r,c) == 1) {
                    if(liveNeighbors < 2){
                        nextBoard.setValue(r,c,0);
                    }else if(liveNeighbors < 4){
                        nextBoard.setValue(r,c,1);
                    }else if(liveNeighbors > 3){
                        nextBoard.setValue(r,c,0);
                    }
                } else {
                    throw new IllegalStateException("value can only be 0 or 1");
                }
            }
        }
        board = nextBoard;
    }

    private int countliveNeighbors(int row, int col, Board board) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < ROW && c >= 0 && c < COL &&
                        !(r == row && c == col) && board.getValue(r, c) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private Board copyBoard(Board board) {
        Board newBoard = new Board(board.getRow(), board.getCol());
        for (int r = 0; r < board.getRow(); r++) {
            for (int c = 0; c < board.getCol(); c++) {
                newBoard.setValue(r, c, board.getValue(r, c));
            }
        }
        return newBoard;
    }


    private Board getBoard() {
        return board;
    }
}
