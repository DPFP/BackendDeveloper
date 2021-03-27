import java.util.LinkedList;
import java.util.List;

public class Permutation {

    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> temp = new LinkedList<>();
        backtrack(nums, temp);

        // print the result
        System.out.println(res);

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> temp) {
        // trigger exit condition (one permutation found)
        if (temp.size() == nums.length) {
            res.add(new LinkedList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // exclude the path already visited
            if (temp.contains(nums[i])) { // O(N)
                continue;
            }
            // make choice for next path
            temp.add(nums[i]);
            // move to next level
            backtrack(nums, temp);
            // cancel previous choice
            temp.removeLast();

        }
    }

    public static void main(String[] args) {
        Permutation sol = new Permutation();
        int[] test1 = { 1, 2, 3, 4 };
        sol.permute(test1);
    }
}
