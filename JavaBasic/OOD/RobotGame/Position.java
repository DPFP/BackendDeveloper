package JavaBasic.OOD.RobotGame;

public class Position {
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
