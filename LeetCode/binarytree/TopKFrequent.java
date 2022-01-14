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
        // vs , should be identical ?
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(k, (a, b) -> Integer.compare(a, b));

        for (Integer key : map.keySet()) {
            pq.add(key);
            // here is the key to the problem. poll the smaller one out;
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
