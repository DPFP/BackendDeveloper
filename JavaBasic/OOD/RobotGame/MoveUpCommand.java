package JavaBasic.OOD.RobotGame;

public class MoveUpCommand implements Command{
    RobotDevice device;

    public MoveUpCommand(RobotDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        this.device.moveUp();
        System.out.println("Move up");
    }

    @Override
    public void undo() {
        this.device.moveDown();
        System.out.println("Move down");
    }
}
