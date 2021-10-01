import java.util.Arrays;

public class Sept30thPartiionKSubSets {
    // refernece https://github.com/grandyang/leetcode/issues/698 for explanation
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num; // sum of all elements
        }
        if (sum % k != 0) { // not divisible
            return false;
        }
        int target = sum / k; // target sum
        Arrays.sort(nums);
        return canPartitionKSubsets(nums, target, k, 0, 0, new boolean[nums.length]);
    }

    private boolean canPartitionKSubsets(int[] nums, int target, int k, int start, int curSum, boolean[] visited) {
        if (k == 1) { // if k == 1, we have one subset
            return true;
        }
        // since we already sort the array
        if (curSum > target) { // if curSum > target, we have to backtrack
            return false;
        }
        // exit condition
        if (curSum == target) { // if curSum == target, then we have found a partition
            return canPartitionKSubsets(nums, target, k - 1, 0, 0, visited);
        }
        for (int i = start; i < nums.length; i++) { // try to find a subset
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (canPartitionKSubsets(nums, target, k, i + 1, curSum + nums[i], visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Sept30thPartiionKSubSets sept30thPartiionKSubSets = new Sept30thPartiionKSubSets();
        System.out.println(sept30thPartiionKSubSets.canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4));
    }

}
