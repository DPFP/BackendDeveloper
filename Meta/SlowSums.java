import java.util.Arrays;
import java.util.PriorityQueue;

public class SlowSums {
    int getTotalTime(int[] arr) {
        // Write your code here
        // Goal: highest penalty
        // what happen if arr.length == 1 ?

        // desc order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // I freak love Stream..so much..
        Arrays.stream(arr).forEach(n -> maxHeap.offer(n));

        int cur = maxHeap.poll();
        int res = 0;
        while (!maxHeap.isEmpty()) {
            cur = cur + maxHeap.poll();
            res = res + cur;
        }

        return res;
    }
}
