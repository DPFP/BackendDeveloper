import java.util.ArrayList;
import java.util.List;

public class FindLeaves {
    // 366. Find Leaves of Binary Tree
    // https://leetcode.com/problems/find-leaves-of-binary-tree/

    // solution from labuladong suggestion
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        maxDepth(root);
        return res;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // find the deepest/longest leave node
        int h = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        // post order traverse
        if (res.size() < h) { // haven't ful-fill all level yet;
            res.add(new ArrayList<>());
        }

        // put all leaves which were in the same level to the list;
        res.get(h - 1).add(root.val);

        return h;
    }
}
