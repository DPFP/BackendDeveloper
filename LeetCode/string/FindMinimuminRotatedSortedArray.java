import java.util.PriorityQueue;

public class FindMinimuminRotatedSortedArray {

    // 153 Find Minimum in Rotated Sorted Array
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

    // PQ - BF solution O(NLogN). not great
    public int findMin(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int n : nums) {
            q.add(n);
        }

        return q.poll();
    }

    // 2nd try with hint #1 from the LC to use "Inflection Point."
    // the worst case still O(N) which is worse than O(logN) :(
    public int findMin2(int[] nums) {
        // from hint #1 compare current with next, if next is smaller. then we know we
        // have found it.
        int value = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }

        // if there is no drop, we know the first one is the samllest one
        return nums[0];
    }

    // binary search approach ;
    public int findMin3(int[] nums) {
        // try binary search ;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }
}
