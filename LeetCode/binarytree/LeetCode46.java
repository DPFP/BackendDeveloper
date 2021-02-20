import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {
    // permutation
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        // Note here is using linkedlist
        LinkedList<Integer> track = new LinkedList<>();

        backTrack(track, nums);

        System.out.println(result);
        return result;
    }

    private void backTrack(LinkedList<Integer> track, int[] n) {

        if (track.size() == n.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < n.length; i++) {
            if (!track.contains(n[i])) {
                track.add(n[i]);
                backTrack(track, n);
                track.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        LeetCode46 sol = new LeetCode46();
        int[] test = { 1, 2, 3 };
        sol.permute(test);
    }

}
