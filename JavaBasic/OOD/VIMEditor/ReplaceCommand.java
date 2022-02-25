package JavaBasic.OOD.VIMEditor;

public class ReplaceCommand implements Command{
    private Operator operator;
    private char c;

    public ReplaceCommand(Operator operator, char c) {
        this.operator = operator;
        this.c = c ;
    }

    @Override
    public void execute() {
        operator.replace(c);
    }

    @Override
    public void undo() {
        //TODO ? how to undo replace ?
//        operator.replace(c);
    }
}
