package JavaBasic.DesignPatterns.CommandPattern;

import java.util.ArrayList;
import java.util.List;

public class PlayWithRemote {
    public static void main(String[] args) {
        ElectronicDevice newDevice = TVRemote.getDevice();

        // TurnTVOn contains the command to turn on the tv
        // When execute() is called on this command object
        // it will execute the method on() in Television
        TurnTVOn onCommand = new TurnTVOn(newDevice);
        DeviceButton onPressed = new DeviceButton(onCommand);
        onPressed.press();

        TurnTVOff offCommand = new TurnTVOff(newDevice);
        onPressed = new DeviceButton(offCommand);
        onPressed.press();

        //----------------------------------------------------------

        // Now when execute() is called volumeUp() of Television executes
        TurnTVUp volUpCommand = new TurnTVUp(newDevice);
        // Calling the execute() causes volumeUp() to execute in Television
        onPressed = new DeviceButton(volUpCommand);
        // When press() is called theCommand.execute(); executes
        onPressed.press();
        onPressed.press();
        onPressed.press();

        //----------------------------------------------------------
        Television newTV = new Television();
        Radio newRadio = new Radio();

        List<ElectronicDevice> devices = new ArrayList<>();
        devices.add(newTV);
        devices.add(newRadio);

        TurnitAllOff turnitAllOffCommand = new TurnitAllOff(devices);
        DeviceButton turnAllOff = new DeviceButton(turnitAllOffCommand);

        turnAllOff.press();

        turnAllOff.pressUndo();
    }
}
