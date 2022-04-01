import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int n : nums) {
            if (count.containsKey(n)) {
                res.add(n);
            } else {
                count.put(n, 1);
            }
        }

        return res;
    }

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that
    // occurs twice. (C: this works, because the problem constrains)
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray sol = new FindAllDuplicatesInAnArray();
        int[] nums = { 1, 1, 2 };
        for (int i : sol.findDuplicates(nums)) {
            System.out.print(i + " ");
        }

        sol.findDuplicates2(nums);
    }
}