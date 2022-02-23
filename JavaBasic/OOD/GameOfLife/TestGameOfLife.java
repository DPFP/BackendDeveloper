package JavaBasic.OOD.GameOfLife;

import java.util.Scanner;

public class TestGameOfLife {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Game of Life ");
        System.out.println("How many row do you want ?");
        int row = scanner.nextInt();

        System.out.println("How many col do you want ?");
        int col = scanner.nextInt();

        GameOfLife gameOfLife = GameOfLife.getInstance(row,col);
        gameOfLife.initialBoard();
        gameOfLife.displayBoard();

        while (true){
            gameOfLife.calculateNextGeneration();
            System.out.println();
            Thread.sleep(500);
            gameOfLife.displayBoard();
            clearScreen();
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
