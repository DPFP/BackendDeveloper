import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    // 13 3Sum
    // https://leetcode.com/problems/3sum/

    // First try --> convert from 3Sum to TwoSum + one, didn't work
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, int[]> map = new HashMap<>();

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[i] != nums[j]) {
                    map.put(nums[i] + nums[j], new int[] { i, j });
                }
            }
        }

        for (Integer n : map.keySet()) {
            System.out.println(n + " " + map.get(n));
            for (int k = 0; k < len; k++) {
                int[] twoSumIndex = map.get(n);
                if (n + nums[k] == 0 && twoSumIndex[0] != k && twoSumIndex[1] != k) {
                    res.add(List.of(nums[twoSumIndex[0]], nums[twoSumIndex[1]], nums[k]));
                }
            }
        }

        return res;
    }

    // solution from LC discussion
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new LinkedList<>();

        // first let sort nums
        Arrays.sort(nums);

        // let us two-pointer
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            // strangely, add the next 3 lines, made the solution even worse ?
            if (nums[i] > 0) {
                break;
            }
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = len - 1;
                // nums[i] + TwoSum = 0
                int twoSum = 0 - nums[i];

                while (left < right) {
                    // ?? sum could be negative number ??
                    if (nums[left] + nums[right] == twoSum) {
                        res.add(List.of(nums[i], nums[left], nums[right]));
                        // remove duplicate element
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // remove duplicate element
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < twoSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
