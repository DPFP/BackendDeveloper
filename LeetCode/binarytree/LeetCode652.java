import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode652 {
    // find duplicate tree

    HashMap<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);

        if (freq == 1) {
            res.add(root);
        }

        memo.put(subTree, freq + 1);

        return subTree;
    }

    public static void main(String[] args) {

        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.left.left = new TreeNode(4);

        test.right = new TreeNode(3);
        test.right.left = new TreeNode(2);
        test.right.left.left = new TreeNode(4);
        test.right.right = new TreeNode(4);

        LeetCode652 sol = new LeetCode652();

        System.out.println(sol.findDuplicateSubtrees(test));

    }

}
