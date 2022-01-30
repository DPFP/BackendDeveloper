import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    // 128 Longest Consecutive Sequence
    // https://leetcode.com/problems/longest-consecutive-sequence/
    // worked solution, but felt like could be better.
    // priority queue push/pop operations are O(log n), so your code is O(n log n).
    public int longestConsecutive(int[] nums) {
        // BF solution using PQ
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int n : nums) {
            q.offer(n);// sort in asc order
        }

        // shot, it ask for the "longest" --> max;
        int max = 0;
        int localMax = 0;

        int pre = q.poll();// need be careful with empty q.

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur - pre == 1) {
                localMax++;
                max = Math.max(localMax, max);
            } else if (cur == pre) {
                continue;
            } else {
                localMax = 0;
            }

            pre = cur;
        }

        return max + 1;
    }

    // great explaination (C: Debug really helped understand the solution)
    // https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted/704537
    public int longestConsecutive2(int[] nums) {
        // does this consider O(N) ? I guess so.
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = 0;
        while (!set.isEmpty()) {
            // the key is start from seed and decrease(-1) and increase(+1) to see if any
            // element is in the Set
            // if is, that means, there is a sequence. (kind like sliding window, expanding
            // the window)
            Integer seed = set.iterator().next();
            int count = 0, left = seed - 1, right = seed;
            while (set.remove(left--))
                count++;
            while (set.remove(right++))
                count++;
            max = Math.max(count, max);
        }
        return max;
    }

    // discuss solution
    // https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
    public int longestConsecutive3(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }
        return res;
    }
}
