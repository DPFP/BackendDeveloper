package LeetCode.BinarySearch;

public class SearchRange {

    // based on solution from labuladong
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;

        int[] res = new int[] { -1, -1 };

        if (len <= 0) {
            return res;
        }

        res[0] = leftIndex(nums, target);

        if (res[0] == -1) {
            return res;
        }

        res[1] = rightIndex(nums, target);

        return res;
    }

    private int leftIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1; // notice here (keep going left)
            }
        }

        // also need check the boundary
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int rightIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1; // notice here (keep going right)
            }
        }

        // also need check the boundary
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 5, 7, 7, 8, 8, 10 };
        SearchRange sol = new SearchRange();
        System.out.println(sol.searchRange(test, 8));
    }
}
