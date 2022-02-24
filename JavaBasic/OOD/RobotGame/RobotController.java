package JavaBasic.OOD.RobotGame;

public class RobotController {
    Command command;

    public RobotController(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}
