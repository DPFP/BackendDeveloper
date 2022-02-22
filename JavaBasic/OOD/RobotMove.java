package JavaBasic.OOD;

class RobotMove {

    enum Direction {
        North,
        West,
        South,
        East
    }

    static int[][] BOARD;
    // final static dirs[][] DIRS = {}; // {North:(0,1), East:(1,0), South:(0,-1),
    // West:(-1,0) }
    int[] position; // (x-row,y-col)
    Direction direction;
    int round = 0;

    // 2069 Walking Robot Simulation II
    // https://leetcode.com/problems/walking-robot-simulation-ii/
    // my discussion
    // https://leetcode.com/problems/walking-robot-simulation-ii/discuss/1764291/My-Brute-Force-Solution-Easy-to-understand
    public RobotMove(int width, int height) {
        // bottom-left (0,0). top-right (width-1, height-1);
        this.BOARD = new int[height][width]; // row,col (x,y)
        // this.DIRS = {{0,1}, {-1,0}, {0,-1}, {1,0}}; //north, west, south, east;
        this.position = new int[] { 0, 0 };
        this.direction = Direction.East; // how to better handle this ?
        this.round = 2 * (width - 1 + height - 1);
    }

    public void step(int num) {
        // cc-wise: east -> north -> west -> south
        // num: 2, 1, ; 2, 1,
        // position[0]: 0, 1, 2; 3,4;
        int width = BOARD[0].length; // 6,
        int height = BOARD.length; // 3,

        // have to do this, otherwise LTE
        num = num % round; // 140/142 cases with only this part

        // have to add this to pass all 142 test cases
        if (num == 0) {
            num = round;
        }
        // position[1]: 0
        while (num > 0) {
            num--;
            switch (this.direction) {
                case East:
                    if (++position[0] < width) {
                        continue; // or break ? or no differences.
                    } else {
                        position[0]--; // (5,0)
                        position[1]++;
                        this.direction = Direction.North;
                    }
                    break;
                case North:
                    if (++position[1] < height) { // (5,3)
                        continue;
                    } else {
                        position[1]--; // (5,2)
                        position[0]--;
                        this.direction = Direction.West;
                    }
                    break;
                case West:
                    if (--position[0] >= 0) { // (5,)
                        continue;
                    } else {
                        position[0]++;
                        position[1]--;
                        this.direction = Direction.South;
                    }
                    break;
                case South:
                    if (--position[1] >= 0) {
                        continue;
                    } else {
                        position[1]++;
                        position[0]++;
                        this.direction = Direction.East;
                    }
                    break;
            }
        }
    }

    public int[] getPos() {
        return this.position; // [4,0];
    }

    public String getDir() {
        // enum with int[] as value ?
        return this.direction.name(); // East;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */