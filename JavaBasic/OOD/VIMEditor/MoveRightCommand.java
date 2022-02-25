package JavaBasic.OOD.VIMEditor;

public class MoveRightCommand implements Command{
    private Operator operator;
    private int n;

    public MoveRightCommand(Operator operator, int n) {
        this.operator = operator;
        this.n = n;
    }

    @Override
    public void execute() {
        System.out.println("move cursor right by " + n );
        operator.moveRight(n);
    }

    @Override
    public void undo() {
        operator.moveLeft(n);
    }
}
