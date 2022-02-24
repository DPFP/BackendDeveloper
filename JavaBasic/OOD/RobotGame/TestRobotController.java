package JavaBasic.OOD.RobotGame;

import java.util.Locale;
import java.util.Scanner;

public class TestRobotController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please specif how many row ?");
        int row = Integer.parseInt(scanner.nextLine());

        System.out.println("Please specif how many col ?");
        int col = Integer.parseInt(scanner.nextLine());

        System.out.println("Please give Robot a name ! ");
        String roboName = scanner.nextLine();

        System.out.println("hello " + roboName);

        //--Set-up------------------------------------
        Robot robot = new Robot(roboName, row,col);
        Board newBoard = Board.getInstance(row,col,robot);

        newBoard.status();

        while(true){
            System.out.println("Please send move command U-up, D-down, L-left, R-right");
            String nextCommand = scanner.nextLine();

            if(nextCommand.length() > 1){
                throw new IllegalArgumentException("Only one character is allowed");
            }

            try{
                processCommand(nextCommand.toUpperCase(Locale.ROOT), robot);
            }catch (IllegalArgumentException e){
                System.out.println(e);
            }
            
            newBoard.status();
        }
    }

    private static void processCommand(String input, RobotDevice robot){
        //------set up the commands
        Command moveUP = new MoveUpCommand(robot);
        RobotController moveUpButton = new RobotController(moveUP);

        Command moveDown = new MoveDownCommand(robot);
        RobotController moveDownButton = new RobotController(moveDown);

        Command moveLeft = new MoveLeftCommand(robot);
        RobotController moveLeftButton = new RobotController(moveLeft);

        Command moveRight = new MoveRightCommand(robot);
        RobotController moveRightButton = new RobotController(moveRight);

        switch (input){
            case "U":
                moveUpButton.press();
                break;
            case "D":
                moveDownButton.press();
                break;
            case "L":
                moveLeftButton.press();
                break;
            case "R":
                moveRightButton.press();;
                break;
            default:
                throw new IllegalArgumentException("Invalid command , only U-u,D-d,L-l,R-r allowed");
        }
    }
}
