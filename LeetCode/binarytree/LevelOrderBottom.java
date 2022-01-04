import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
    // 107. Binary Tree Level Order Traversal II
    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

    // Solution from Labuladong -- Not the best solutio out there, definitely room
    // for improvement.
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        // have to use LinkedList here, so I can use addFirst/Last
        LinkedList<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                curLevel.add(cur.val);

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // here is the key, always add to the wrong of the list
            res.addFirst(curLevel);
        }

        return res;
    }
}
