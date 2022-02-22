package JavaBasic.OOD.RobotGame;

import java.util.UUID;

public class Robot {

    private UUID uuid;
    private String name;
    private Position position;

    public Robot(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
        this.position = new Position(0, 0);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    //TODO I could pass the whole board to here, if there is obstacle
    public void move(DIR dir, int r, int c) {
        switch (dir) {
            case UP:
                //(-1,0)
                this.position = getNextPosition(position, -1, 0, r, c);
                break;
            case DOWN:
                //(1,0)
                this.position = getNextPosition(position, 1, 0, r, c);
                break;
            case LEFT:
                //(0,-1)
                this.position = getNextPosition(position,0,-1, r,c);
                break;
            case RIGHT:
                //(0,1)
                this.position = getNextPosition(position,0,1, r,c);
                break;
        }
        System.out.println(this.name + " moved "+ dir + " to new position " + position.getX() + "," + position.getY());
    }

    private Position getNextPosition(Position cur, int rv, int cv, int r, int c) {
        int x = cur.getX() + rv;
        int y = cur.getY() + cv;
        if (x < 0 || x >= r || y < 0 || y >= c) {
            //or this could throw some exception ?
            System.out.println("Exceed boundary -- not moving");
            return cur;
        } else {
            return new Position(x, y);
        }
    }
}
