import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueueRemovals {

    // This one is hard.
    // https://leetcode.com/discuss/interview-question/1039925/Facebook-Practice-question-or-Queue-Removals
    private static int[] findPositions(int[] arr, int x) {
        // Write your code here
        // hash Map keep track of element + original index ?
        // key: index , value: element (as it could have duplidated )
        // Queue --> linkedList offer/poll. //count iteration ==> original element and
        // index;
        Map<Integer, Integer> indexMap = new HashMap<>(); // key: element, value:originalIndex;
        Queue<Integer> queue = new LinkedList<>(); // do I need max Queue here ? Can't the order have to be maintained.

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            // we ignore the duplicated element here
            if (!indexMap.containsKey(n)) {
                indexMap.put(n, i);
            }
            queue.offer(n);
        }

        int counter = 0; // count the iteration (will be used to calculate the original index)
        int[] res = new int[x];

        for (int i = 0; i < x; i++) {
            int count = 1;

            int max = -1;
            int maxIndex = -1;
            int maxTobeDeletedIndex = 0;

            while (!queue.isEmpty() && count <= x) {
                int cur = queue.poll();

                if (cur > max) {
                    max = cur;
                    if (indexMap.containsKey(max)) {
                        maxIndex = indexMap.get(max);
                    }
                    maxTobeDeletedIndex = queue.size();
                }
                // TODO how to delete max ?
                if (cur - 1 >= 0) {
                    cur--;
                }
                queue.offer(cur);
                count++;
            }
            queue.remove(maxTobeDeletedIndex);

            res[i] = maxIndex;
            counter++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] t1 = { 1, 2, 2, 3, 4, 5 };

        Arrays.stream(findPositions(t1, 5)).forEach(n -> System.out.println(n));
    }
}
