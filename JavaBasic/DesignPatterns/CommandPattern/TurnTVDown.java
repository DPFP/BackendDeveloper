package JavaBasic.DesignPatterns.CommandPattern;

//Command
public class TurnTVDown implements Command {
    private ElectronicDevice theDevice;

    public TurnTVDown(ElectronicDevice newDevice) {
        this.theDevice = newDevice;
    }

    @Override
    public void execute() {
        theDevice.volumeDown();
    }

    @Override
    public void undo() {
        theDevice.volumeUp();
    }
}
