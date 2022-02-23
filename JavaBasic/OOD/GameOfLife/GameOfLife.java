package JavaBasic.OOD.GameOfLife;

public class GameOfLife {
    private Board board;
    private int ROW;
    private int COL;

    private static GameOfLife instance;

    private GameOfLife(int row, int col) {
        this.ROW = row;
        this.COL = col;
        this.board = new Board(row, col);
    }

    public static GameOfLife getInstance(int row, int col) {
        if (instance == null) {
            instance = new GameOfLife(row, col);
        }
        return instance;
    }

    public void initialBoard() {
        //set random live with 1;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                int random = (int) (Math.random() * 3) + 1; //  every 1/4 will be live cell
                if (random == 3) {
                    board.setValue(r, c, 1);
                }
            }
        }
    }

    public void displayBoard() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (board.getValue(r, c) == 1) {
                    System.out.print(ConsoleColors.GREEN_BACKGROUND + board.getValue(r, c) + " " + ConsoleColors.RESET);
                } else {
                    System.out.print(ConsoleColors.RED_BACKGROUND + board.getValue(r, c) + " " + ConsoleColors.RESET);
                }

            }
            System.out.println();
        }
    }

    public int calculateNextGeneration() {
        int liveTotal = 0;
        Board nextBoard = copyBoard(board);
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                int liveNeighbors = countliveNeighbors(r, c, board);
                if (liveNeighbors == 3) {
                    nextBoard.setValue(r, c, 1);
                    liveTotal++;
                } else if (board.getValue(r, c) == 1 && liveNeighbors == 2) {
                    nextBoard.setValue(r, c, 1);
                    liveTotal++;
                } else {
                    nextBoard.setValue(r, c, 0);
                }

            }
        }
        board = nextBoard;

        return liveTotal;
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
}
