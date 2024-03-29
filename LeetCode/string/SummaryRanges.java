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
            // starting point --> a (current value)
            int a = nums[i];

            // kind like the mountain, if it keep including for next
            // can't replace nums[i] here, but is stil incremeting
            while (i + 1 < len && (nums[i + 1] - nums[i]) == 1) {
                i++;
            }

            // nums[i] ==> b (or the End) for current iteration
            // means i changed. aka end changed
            if (a != nums[i]) {
                res.add(a + "->" + nums[i]);
            } else {
                // means i didn't move. end didn't change
                res.add(a + "");
            }
        }

        return res;
    }
}
