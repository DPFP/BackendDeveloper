package JavaBasic.DesignPatterns.CommandPattern;

import java.util.List;

public class TurnitAllOff implements Command{
    List<ElectronicDevice> devices;

    public TurnitAllOff(List<ElectronicDevice> devices) {
        this.devices = devices;
    }

    @Override
    public void execute() {
        for(ElectronicDevice device : devices){
            device.off();
        }
    }

    @Override
    public void undo() {
        for(ElectronicDevice device : devices){
            device.on();
        }
    }
}
