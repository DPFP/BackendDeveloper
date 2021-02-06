import java.util.LinkedList;
import java.util.List;

public class Permutation {
    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);

        // print the result
        System.out.println(res);

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        // trigger exit condition (one permutation found)
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // exclude the path already visited
            if (track.contains(nums[i])) { // O(N)
                continue;
            }
            // make choice for next path
            track.add(nums[i]);
            // move to next level
            backtrack(nums, track);
            // cancel previous choice
            track.removeLast();

        }
    }

    public static void main(String[] args) {
        Permutation sol = new Permutation();
        int[] test1 = { 1, 2, 3, 4 };
        sol.permute(test1);
    }
}
