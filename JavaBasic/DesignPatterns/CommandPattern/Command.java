package JavaBasic.DesignPatterns.CommandPattern;

//Each command you want to issue will implement the Command interface
public interface Command {

    public void execute();

    //optional
    public void undo();
}
