package JavaBasic.OOD.RobotGame;

import java.util.UUID;

public class Robot implements RobotDevice{

    private UUID uuid;
    private String name;
    private Position position;

    private int ROW;
    private int COL;

    public Robot(String name, int row, int col) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.position = new Position(5, 5);
        this.ROW = row;
        this.COL = col;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    //TODO I could pass the whole board to here, if there is obstacle
    @Deprecated
    public void move(DIR dir) {
        switch (dir) {
            case UP:
                //(-1,0)
                setNextPosition(-1, 0);
                break;
            case DOWN:
                //(1,0)
                 setNextPosition(1, 0);
                break;
            case LEFT:
                //(0,-1)
                 setNextPosition(0,-1);
                break;
            case RIGHT:
                //(0,1)
                 setNextPosition(0,1);
                break;
        }
        System.out.println(this.name + " moved "+ dir + " to new position " + position.getX() + "," + position.getY());
    }

    private void setNextPosition(int rv, int cv) {
        int x = position.getX() + rv;
        int y = position.getY() + cv;
        //TODO also check if (x,y) === 1 (obstacle)
        if (x < 0 || x >= ROW || y < 0 || y >= COL) {
            //or this could throw some exception ?
            System.out.println("Exceed boundary -- not moving");
        } else {
            position.setX(x);
            position.setY(y);
        }
    }

    @Override
    public void moveUp() {
        setNextPosition(-1, 0);
    }

    @Override
    public void moveDown() {
        setNextPosition( 1, 0);
    }

    @Override
    public void moveLeft() {
         setNextPosition(0,-1);
    }

    @Override
    public void moveRight() {
         setNextPosition(0,1);
    }
}
