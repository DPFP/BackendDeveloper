import java.util.HashMap;
import java.util.Map;

public class Sept10th {

    public int numberOfArithmeticSlices(int[] nums) {
        // https://www.cnblogs.com/grandyang/p/6057934.html

        int res = 0;
        Map<Integer, Integer>[] map = new HashMap[nums.length];

        for (int i = 0; i < nums.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;

                int d = (int) diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Sept10th sept10th = new Sept10th();
        int[] nums = { 2, 4, 6, 8, 10 };
        System.out.println(sept10th.numberOfArithmeticSlices(nums));
    }
}
