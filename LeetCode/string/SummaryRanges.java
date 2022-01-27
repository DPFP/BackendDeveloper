import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {

    // 228. Summary Ranges
    // https://leetcode.com/problems/summary-ranges/

    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> res = new LinkedList<>();

        if (nums == null || len == 0) {
            return res;
        }

        if (len == 1) {
            res.add(nums[0] + "");
            return res;
        }

        for (int i = 0; i < len; i++) {
            int a = nums[i];

            // kind like the mountain
            while (i + 1 < len && (nums[i + 1] - nums[i]) == 1) {
                i++;
            }

            // if a differe then "a -> b" b = nums[i]
            if (a != nums[i]) {
                res.add(a + "->" + nums[i]);
            } else {
                res.add(a + "");
            }
        }

        return res;
    }
}
