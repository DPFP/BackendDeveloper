package LeetCode.BinarySearch;

public class SearchinRotatedSortedArray {
    // 33 Search in Rotated Sorted Array
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    // when see the following requirements, you know it is binary search
    // "You must write an algorithm with O(log n) runtime complexity."

    // first try -- 大开脑洞的答案.
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        } else if (nums.length == 1 && nums[0] != target) {
            return -1;
        }

        int rotated = nums[0] - 1;

        if (nums[rotated + 1] != target) {
            return -1;
        } else {
            return rotated + 1;
        }
    }

    // discussion solution: the key is to figure out how many it rotated
    // https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution
    public int search2(int[] nums, int target) {

        int len = nums.length;

        int lo = 0;
        int hi = len - 1;

        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would
        // have been terminated.
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        // key part;
        int rot = lo; // should using my method ? nums[0] - 1 ? nope, not working [3,1]
        // int rot = nums[0] - 1;

        lo = 0;
        hi = len - 1;

        while (lo <= hi) { // notice <= instead of <
            int mid = (lo + hi) / 2;
            int realmid = (mid + rot) % len;

            if (nums[realmid] == target) {
                return realmid;
            }

            if (nums[realmid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    // improved appraoch
    public int search3(int[] nums, int target) {
        int minIdx = findMinIdx(nums);

        if (target == nums[minIdx]) {
            return minIdx;
        }

        int len = nums.length;
        int start = (target <= nums[len - 1]) ? minIdx : 0;
        int end = (target > nums[len - 1]) ? minIdx : len - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    // O( log(n) )
    public int findMinIdx(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}
