package JavaBasic.OOD.VIMEditor;

public class FindToLeftCommand implements Command{
    private Operator operator;
    private char c;

    public FindToLeftCommand(Operator operator, char c) {
        this.operator = operator;
        this.c = c ;
    }

    @Override
    public void execute() {
        operator.findToLeft(c);
    }

    @Override
    public void undo() {
        operator.findToRight(c);
    }
}
