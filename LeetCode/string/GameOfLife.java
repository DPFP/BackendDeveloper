public class GameOfLife {

    //LC 289 - Game of Life
    //https://leetcode.com/problems/game-of-life/

    //Solution https://leetcode.com/problems/game-of-life/discuss/73366/Clean-O(1)-space-O(mn)-time-Java-Solution/445390
    public void gameOfLife(int[][] board) {
        int[][] output=new int[board.length][board[0].length];

        for(int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[i].length;j++)
            {
                int neighbour = count(i,j,board);
                //Rule 1
                if(board[i][j]==1 && neighbour<2)
                    output[i][j]=0;
                    //Rule 2
                else if(board[i][j]==1 && (neighbour==2 || neighbour==3))
                    output[i][j]=1;
                    //Rule 3
                else if(board[i][j]==1 && neighbour>3)
                    output[i][j]=0;
                    //Rule 4
                else if(board[i][j]==0 && neighbour==3)
                    output[i][j]=1;
            }

        }

        for(int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[i].length;j++)
            {
                board[i][j]=output[i][j];
            }
        }

    }
    public int count(int i,int j,int[][]board)
    {
        int count=0;
        //To find value in 8 Direction left,right,top,down,top left ,top right,bottom left, bottom right
        int[][] direction={{0,-1},{0,1},{1,0},{1,-1},{1,1},{-1,-1},{-1,1},{-1,0}};

        for(int[] dir:direction)
        {
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length)
            {
                count+=board[x][y];
            }
        }
        return count;
    }

    //Another precise solution
    int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife2(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int live=0;
                for(int[] d:dir){
                    if(d[0]+i<0 || d[0]+i>=board.length || d[1]+j<0 || d[1]+j>=board[0].length) continue;
                    if(board[d[0]+i][d[1]+j]==1 || board[d[0]+i][d[1]+j]==2) live++;
                }
                if(board[i][j]==0 && live==3) board[i][j]=3;
                if(board[i][j]==1 && (live<2 || live>3)) board[i][j]=2;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] %=2;
            }
        }
}
