package JavaBasic.DesignPatterns.CommandPattern;

//Invoker
// It has a method press() that when executed causes the execute method to be called

// The execute method for the Command interface then calls
// the method assigned in the class that implements the command interface
public class DeviceButton {
    Command theCommand;

    public DeviceButton(Command theCommand) {
        this.theCommand = theCommand;
    }

    //C: why don't we pass the command to the press() method ?
    public void press(){
        theCommand.execute();
    }

    public void pressUndo(){
        theCommand.undo();
    }

}
