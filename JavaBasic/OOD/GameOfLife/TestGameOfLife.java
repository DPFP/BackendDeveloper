package JavaBasic.OOD.GameOfLife;

public class TestGameOfLife {

    public static void main(String[] args) throws InterruptedException {
        GameOfLife gameOfLife = new GameOfLife( 10, 30);
        gameOfLife.initialBoard();
        gameOfLife.displayBoard();
        while (true){
            gameOfLife.calculateNextGeneration();
            System.out.println();
            Thread.sleep(500);
            gameOfLife.displayBoard();
        }
//        clearScreen(); //not working in IDE
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
