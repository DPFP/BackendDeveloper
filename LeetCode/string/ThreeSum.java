import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) { // notice len - 2
            // strangely, add the next 3 lines, made the solution even worse ?
            if (nums[i] > 0) {
                // isn't should be using continue (to skp the current loop, instead of break)
                // tried both "continue" & "break", both worked ?
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

    // 2nd try on 1/23
    public List<List<Integer>> threeSum3(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        // one + TwoSum

        // first sort the array
        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;

        // for(int i=0;i < len; i++){
        for (int i = 0; i < len - 2; i++) { // notice len - 2
            int first = nums[i];

            // skip the currently round
            if (first > 0) {
                // break or continue ? ; both worked (it should be continue)
                continue;
            }

            if (i == 0 || (i > 0 && first != nums[i - 1])) { //// skip the duplicatae element ?
                // int left = 0; //should this be i ? Yes
                int left = i + 1; // grab next after i
                int right = len - 1;

                // twoSum target
                int twoSum = 0 - first;

                while (left < right) {
                    if (nums[left] + nums[right] < twoSum) {
                        left++;
                    } else if (nums[left] + nums[right] > twoSum) {
                        right--;
                    } else { // found twoSum
                             // get one result;
                             // res.add(List.of(i, numsleft, right)); need get the actual value, not just the
                             // index
                        res.add(List.of(first, nums[left], nums[right]));

                        // missing the following parts
                        while (left < right && nums[left] == nums[left + 1]) { // if next from left is the same, skip
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) { // if next from right is the same, skip
                            right--;
                        }
                        // move on to next pair (after we already find one pair value)
                        left++;
                        right--;
                    }
                } // end while
            } // end if check
        } // end for

        return res;
    }
}
