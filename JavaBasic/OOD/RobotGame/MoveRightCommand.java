package JavaBasic.OOD.RobotGame;

public class MoveRightCommand implements Command{
    RobotDevice device;

    public MoveRightCommand(RobotDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        this.device.moveRight();
        System.out.println("Move Right");
    }

    @Override
    public void undo() {
        this.device.moveLeft();
        System.out.println("Move Left");
    }
}
