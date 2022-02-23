package JavaBasic.OOD.RobotGame;

import java.util.Scanner;

public class TestRobot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please specif how many row ?");
        int row = Integer.parseInt(scanner.nextLine());

        System.out.println("Please specif how many col ?");
        int col = Integer.parseInt(scanner.nextLine());

        System.out.println("Please give Robot a name ! ");
        String roboName = scanner.nextLine();

        System.out.println("hello " + roboName);

        Robot robot = new Robot(roboName);
        Board newBoard = new Board(row,col,robot);

        while(true){
            System.out.println("Please send move command U-up, D-down, L-left, R-right");
            String nextCommand = scanner.nextLine();

            if(nextCommand.length() > 1){
                throw new IllegalArgumentException("Only one character is allowed");
            }

            robot.move(getDirFromUserInput(nextCommand), row,col);
            newBoard.status();
        }
    }

    private static DIR getDirFromUserInput(String input){
        switch (input){
            case "U":
                return DIR.UP;
            case "D":
                return DIR.DOWN;
            case "L":
                return DIR.LEFT;
            case "R":
                return DIR.RIGHT;
        }
        return null;
    }
}
