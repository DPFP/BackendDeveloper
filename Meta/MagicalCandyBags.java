import java.util.Arrays;
import java.util.PriorityQueue;

public class MagicalCandyBags {

    int maxCandies(int[] arr, int k) {
        // Write your code here
        // Do i really want keep the top k bags ? Nope -> double k will do ?
        int counter = 0;

        // desc order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));

        Arrays.stream(arr).forEach(a -> maxHeap.offer(a));

        for (int i = 0; i < k; i++) {
            int cur = maxHeap.poll();
            counter = counter + cur;
            maxHeap.offer(cur / 2);
        }

        return counter;
    }
}
