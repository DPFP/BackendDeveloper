package JavaBasic.OOD.VIMEditor;

public class VIMController {
    Command command;

    public VIMController(Command command) {
        this.command = command;
    }

    public void press(){
        this.command.execute();;
    }

    public void pressUndo(){
        this.command.undo();
    }
}
