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

    // 1) If rotate, A[min] < A[min - 1]; 2) If not, A[0]. Therefore, we can use
    // binary search: check the middle element, if it is less than previous one,
    // then it is minimum. If not, there are 2 conditions as well: If it is greater
    // than both left and right element, then minimum element should be on its
    // right, otherwise on its left.

    // binary search approach ;
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48484/A-concise-solution-with-proof-in-the-comment
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

    public static void main(String[] args) {
        System.out.println(1 / 2);
    }
}
