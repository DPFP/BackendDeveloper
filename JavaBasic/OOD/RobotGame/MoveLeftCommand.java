package JavaBasic.OOD.RobotGame;

public class MoveLeftCommand implements Command{
    RobotDevice device;

    public MoveLeftCommand(RobotDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        this.device.moveLeft();
        System.out.println("Move Left");
    }

    @Override
    public void undo() {
        this.device.moveRight();
        System.out.println("Move Right");
    }
}
