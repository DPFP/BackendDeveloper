import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueueRemovals {

    // This one is hard.
    // https://leetcode.com/discuss/interview-question/1039925/Facebook-Practice-question-or-Queue-Removals

    // 1st try, didn't work :
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

    // Online LC discussion solution worked
    // https://leetcode.com/discuss/interview-question/1039925/Facebook-Practice-question-or-Queue-Removals/849658
    private static int[] findPositions2(int[] arr, int x) {
        // Write your code here

        x = Math.min(x, arr.length); // C: this is really a smart move;
        int[] result = new int[x];

        int max, maxPos = 0;
        int start = 0;
        int readCount;

        for (int i = 0; i < x; i++) {
            readCount = Math.min(x, arr.length - i);

            maxPos = start; // noticed didn't reset start here for next iteration, reset on the %
            max = arr[maxPos];

            // this will do two things.
            // decrease the value -1 and find the max & maxPos
            while (readCount > 0) {
                if (arr[start] != -1) { // if is not removed element
                    if (max < arr[start]) {
                        max = arr[start];
                        maxPos = start;
                    }
                    if (arr[start] > 0) {
                        arr[start] = arr[start] - 1;
                    }
                    readCount--;
                }
                start++;
                start = start % arr.length; // this will ensure start will reset
            }

            // mark the maxPos as -1, means removed
            // (not actually remove the value, but mark it as -1)
            arr[maxPos] = -1;
            // add the maxPos to result set -- which is the (largest element) one removed
            // from the queue
            result[i] = maxPos + 1; // have to +1 is because one-based index
        }

        return result;
    }

    public static void main(String[] args) {
        int[] t1 = { 1, 2, 2, 3, 4, 5 };

        Arrays.stream(findPositions2(t1, 5)).forEach(n -> System.out.println(n));
    }
}
