import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode752 {

    // You are given a list of deadends dead ends, meaning if the lock displays any
    // of these codes, the wheels of the lock will stop turning and you will be
    // unable to open it.

    // Given a target representing the value of the wheels that will unlock the
    // lock, return the minimum total number of turns required to open the lock, or
    // -1 if it is impossible.

    //#1, try permuate all the combination
    //#2, solve the unlock by ignore the limitation
    //#3, add the limitation 


    // turn up (this is how to turn the lock)
    String plusOne(String s, int position) {
        char[] ch = s.toCharArray();
        if (ch[position] == '9') {
            ch[position] = '0';
        } else {
            ch[position] += 1;
        }
        return new String(ch);
    }

    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    int openLock(String[] deadends,String target) {
        //BFS 
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                //#3, add limitaion 
                if(Arrays.asList(deadends).contains(cur)){
                    continue;
                }

                if(cur.equalsIgnoreCase(target)){
                    System.out.println(cur);
                    System.out.println(step);
                    return step; 
                }
                
                for(int j=0; j<4 ; j++){
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    q.offer(up);
                    q.offer(down);
                }
            }
            //#2, count steps 
            step++;
        }
        System.out.println("Not feasible");
        return - 1;
    }

    public static void main(String[] args) {
        LeetCode752 sol = new LeetCode752();

        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        assert sol.openLock(deadends,target) == 6 : "Failed";

        String[] deadends2 = { "8888"};
        String target2 = "0009";
        assert sol.openLock(deadends2,target2) == 1 : "Failed";

        String[] deadends3 = { "0000"};
        String target3 = "8888";
        assert sol.openLock(deadends3,target3) == -1 : "Failed";

        //dead loop --> exceed time limit 
        String[] deadends4 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target4 = "8888";
        assert sol.openLock(deadends4,target4) == -1 : "Failed";
    }
}
