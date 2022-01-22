import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // solution from discussion
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        // Key: value, Value: index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 7 ? No ; 7
            if (map.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                break;
            }
            // (2,0)
            map.put(nums[i], i);
        }

        return res;
    }
}
