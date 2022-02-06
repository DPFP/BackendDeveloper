import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LargestTripleProducts {

    int[] findMaxProduct(int[] arr) {
        // Write your code here
        int len = arr.length;

        int[] res = new int[len];

        // asc order
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Iterator<Integer> it;

        for (int i = 0; i < len; i++) {
            pq.offer(arr[i]);

            if (pq.size() > 3) {
                // detch the smallest
                pq.poll();
            }

            if (i < 2) {
                res[i] = -1;
            } else {
                it = pq.iterator();
                int val = 1;

                while (it.hasNext()) {
                    val = val * it.next();
                }

                res[i] = val;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int[] t1 = { 2, 1, 2, 1, 2 };

        // asc order
        Arrays.stream(t1).forEach(a -> pq.add(a));

        Iterator<Integer> it = pq.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // while (!pq.isEmpty()) {
        // System.out.println(pq.poll());
        // }
    }
}
