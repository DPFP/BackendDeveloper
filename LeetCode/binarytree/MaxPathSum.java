public class MaxPathSum {
    // 124. Binary Tree Maximum Path Sum
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/

    // first try -- didn't work
    public int maxPathSum(TreeNode root) {
        int max = -1;
        if (root == null) {
            return max;
        }

        // BFS
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // do something to check the max
            max = Math.max(pathSum(cur, 0), max);

            // add left & right
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return max;
    }

    // DFS search -- how to handel 2-1-3 ??? look up the parents
    private int pathSum(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }

        if (node.left == null && node.right == null) {
            return sum;
        }

        return Math.max(pathSum(node.left, sum + node.val), pathSum(node.right, sum + node.val));
    }
}
