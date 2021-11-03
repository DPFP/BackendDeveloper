import java.util.ArrayList;
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
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int levelNum = queue.size(); // 1

            for (int i = 0; i < levelNum; i++) { // what current in queue need be process
                TreeNode current = queue.poll(); // -- or remove();
                curLevel.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left); // ++
                }
                if (current.right != null) {
                    queue.offer(current.right); // ++
                }
            }
            res.add(curLevel);
        }
        return res;
    }

}
