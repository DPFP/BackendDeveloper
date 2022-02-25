package JavaBasic.OOD.VIMEditor;

public class FindToRightCommand implements Command{
    private Operator operator;
    private char c;

    public FindToRightCommand(Operator operator, char c) {
        this.operator = operator;
        this.c = c ;
    }

    @Override
    public void execute() {
        operator.findToRight(c);
    }

    @Override
    public void undo() {
        operator.findToLeft(c);
    }
}
