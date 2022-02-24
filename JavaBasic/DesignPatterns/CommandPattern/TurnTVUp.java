package JavaBasic.DesignPatterns.CommandPattern;

//Command
public class TurnTVUp implements Command {
    private ElectronicDevice theDevice;

    public TurnTVUp(ElectronicDevice newDevice) {
        this.theDevice = newDevice;
    }


    @Override
    public void execute() {
        theDevice.volumeUp();
    }

    @Override
    public void undo() {
        theDevice.volumeDown();
    }
}
