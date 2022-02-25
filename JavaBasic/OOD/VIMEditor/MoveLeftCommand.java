package JavaBasic.OOD.VIMEditor;

public class MoveLeftCommand implements Command{
    private Operator operator;
    private int n;

    public MoveLeftCommand(Operator operator, int n) {
        this.operator = operator;
        this.n = n;
    }

    @Override
    public void execute() {
        System.out.println("move cursor left by " + n );
        operator.moveLeft(n);
    }

    @Override
    public void undo() {
        operator.moveRight(n);
    }
}
