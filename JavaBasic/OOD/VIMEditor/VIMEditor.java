package JavaBasic.OOD.VIMEditor;

import java.util.Scanner;

public class VIMEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your testing String line : ");
        String lineInput = scanner.nextLine();
        VIMOperator operator = new VIMOperator(lineInput);

        String command = "";
        while (true) {
            command = scanner.nextLine();
            try {
                processCommand(operator, command);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private static void processCommand(VIMOperator operator, String command) {
        char charToUse = 0;
        if (command.length() > 1) {
            charToUse = command.charAt(1);
        }
        //Character.isDigit()

        switch (command.charAt(0)) {
            case 'h':
                Command moveLeftCommand = new MoveLeftCommand(operator, 1);
                VIMController moveLeftController = new VIMController(moveLeftCommand);
                moveLeftController.press();
                break;
            case 'l':
                Command moveRightCommand = new MoveRightCommand(operator, 1);
                VIMController moveRightController = new VIMController(moveRightCommand);
                moveRightController.press();
                break;
            case 'r':
                //check exception
                Command replaceCommand = new ReplaceCommand(operator, charToUse);
                VIMController replaceController = new VIMController(replaceCommand);
                replaceController.press();
                break;
            case 'f':
                //check exception
                Command findToRightCommand = new FindToRightCommand(operator, charToUse);
                VIMController findToRightController = new VIMController(findToRightCommand);
                findToRightController.press();
                break;
            case 'F':
                //check exception
                Command findToLeftCommand = new FindToLeftCommand(operator, charToUse);
                VIMController findToLeftController = new VIMController(findToLeftCommand);
                findToLeftController.press();
                break;
            case 'q':
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException("Sorry, the command '" + command.charAt(0) + "' is not supported yet ");
        }

    }

}
