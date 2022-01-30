import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    // didn't work, overthinking
    // Will Start with PQ, but probably will LTE, let see
    // can't work because of there is no index in the queue.
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;

    public FindMedianFromDataStream() {
        this.minQueue = new PriorityQueue<>();
        this.maxQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
        // if (!this.minQueue.isEmpty() && this.minQueue.last() <= num) {
        // this.minQueue.offer(num);
        // } else if (!this.maxQueue.isEmpty() && this.maxQueue.first() <= num) {
        // this.maxQueue.offer(num);
        // } else {

        // }
        // how to decide what the first element to add if it 100
        // overthiking
    }

    public double findMedian() {
        Double res = 0.0;
        return res;
    }

    // similar solution
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian2() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public void addNum2(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

}

// working solution
class MedianFinder {
    // Will Start with PQ, but probably will LTE, let see
    // can't work because of there is no index in the queue.
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        this.minQueue = new PriorityQueue<>();
        this.maxQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
        // how to decide what the first element to add if it 100
        // overthiking

        // still trying to understand the following block of code.
        // this ensured whatever the number added will be go through both Queue, to
        // ensure the right value is in the middle !!! Awesome solution
        if (minQueue.size() >= maxQueue.size()) {
            minQueue.offer(num);
            maxQueue.offer(minQueue.poll());
        } else {
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
        }

        // we know the large will gain one more item and small will remain the same
        // size, but we cannot just push the item into large. What we should do is we
        // push the new number into small and pop the maximum item from small then push
        // it into large (all the pop and push here are heappop and heappush). By doing
        // this kind of operations for the two scenarios we can keep our invariant.
        // https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find
    }

    public double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (maxQueue.size() < minQueue.size()) {
            return minQueue.peek(); // noticed the peek()
        } else if (maxQueue.size() > minQueue.size()) {
            return maxQueue.peek(); // noticed the peek()
        }

        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (maxQueue.peek() + minQueue.peek()) / 2.0; // noticed the 2.0 & peek()
    }
}
