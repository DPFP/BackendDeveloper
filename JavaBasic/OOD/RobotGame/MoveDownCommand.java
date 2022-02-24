package JavaBasic.OOD.RobotGame;

public class MoveDownCommand implements Command{
    RobotDevice device;

    public MoveDownCommand(RobotDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        this.device.moveDown();
        System.out.println("Move Down");
    }

    @Override
    public void undo() {
        this.device.moveUp();
        System.out.println("Move Up");
    }
}
