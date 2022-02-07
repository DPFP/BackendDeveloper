import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianStream {

    // didn't work because i messed up the add & calculate median logic
    private static int[] findMedian(int[] arr) {
        // Write your code here
        int len = arr.length;
        int[] res = new int[len];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int median = 0;
        for (int i = 0; i < len; i++) {
            if (minHeap.size() >= maxHeap.size()) {
                minHeap.offer(arr[i]);
                maxHeap.offer(minHeap.poll());
                median = minHeap.peek();
            } else if (minHeap.size() < maxHeap.size()) {
                maxHeap.offer(arr[i]);
                minHeap.offer(maxHeap.poll());
                median = maxHeap.peek();
            } else if (minHeap.size() > 0 && maxHeap.size() > 0) {
                median = (minHeap.peek() + maxHeap.peek()) / 2;
            }
            res[i] = median;
        }

        return res;
    }

    // 2nd try worked
    int[] findMedian2(int[] arr) {
        // Write your code here
        int len = arr.length;
        int[] res = new int[len];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < len; i++) {

            // add element
            if (minHeap.size() >= maxHeap.size()) {
                minHeap.offer(arr[i]);
                maxHeap.offer(minHeap.poll());
                // median = minHeap.peek();
            } else if (minHeap.size() < maxHeap.size()) {
                maxHeap.offer(arr[i]);
                minHeap.offer(maxHeap.poll());
                // median = maxHeap.peek();
            }

            // find median
            if (minHeap.size() < maxHeap.size()) {
                res[i] = maxHeap.peek();
            } else if (minHeap.size() > maxHeap.size()) {
                res[i] = minHeap.peek();
            } else {
                res[i] = (minHeap.peek() + maxHeap.peek()) / 2;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] t1 = { 5, 15, 1, 3 };

        int[] res = findMedian(t1);

        Arrays.stream(res).forEach(a -> System.out.println(a));
    }
}
