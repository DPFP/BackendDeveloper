import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
     * = left; this.right = right; } }
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 1, I know it gonna to use Queue
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res.add(Arrays.asList(root.val));

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            List<Integer> curLevel = new ArrayList<>();
            if (current.left != null) {
                curLevel.add(current.left.val);
                queue.add(current.left);
            }
            if (current.right != null) {
                curLevel.add(current.right.val);
                queue.add(current.right);
            }
            if (curLevel.size() > 0) {
                res.add(curLevel);
            }
        }

        return res;
    }

}
