import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    // 347. Top K Frequent Elements
    // https://leetcode.com/problems/top-k-frequent-elements/

    public int[] topKFrequent(int[] nums, int k) {
        // BF solution HashMap + Heap
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            // map.putIfAbsent(i,1);
            // map.put(i, map.get(i)+1);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // desceding order
        // you can actually pass the Map.get() into.comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(map.get(a), map.get(b)));
        // vs below , should be identical ? The following not gonna work , because it
        // wasn't compare the map !!! 1/15
        // PriorityQueue<Integer> pq2 = new PriorityQueue<>(k, (a, b) ->
        // Integer.compare(a, b));

        for (Integer key : map.keySet()) {
            // here is the part that Heap/PQ will do it job, it will add value based on the
            // map.value()
            pq.add(key);
            // here is the key to the problem. poll the smaller one out;(because it is
            // minHeap)
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
