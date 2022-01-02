import java.util.LinkedList;
import java.util.Queue;

public class MaxPathSum {
    // 124. Binary Tree Maximum Path Sum
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/

    // first try -- didn't work
    private int max;
    private int maxDepth;

    public int maxPathSum(TreeNode root) {
        max = -1;

        if (root == null) {
            return max;
        }
        // BFS
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // do something to check the max
            max = Math.max(maxSum(cur, 0), max);

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
    private int maxSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        // if(node.left == null && node.right == null){
        // return sum;
        // }

        int left = maxSum(node.left, sum);
        int right = maxSum(node.right, sum);

        maxDepth = Math.max(max, left + right);

        return Math.max(left, right) + sum;
    }

    // Second try - close but still didn't work.
    public int maxPathSum2(TreeNode root) {
        int max = 0; // this seems be the problem ?
        if (root == null) {
            return max;
        }
        // Do I even need BFS or DFS is good enough ?
        oneSideMax(root, max);

        return max;
    }

    // why I can't pass the max like the following ?
    // In Java, it is not possible to pass primitives by reference. To emulate this,
    // you must pass a reference to an instance of a mutable wrapper class. (e.g.
    // wrap it in array/list)
    public int oneSideMax(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int leftMax = oneSideMax(root.left, max);
        int rightMax = oneSideMax(root.right, max);

        max = Math.max(max, leftMax + rightMax);

        return Math.max(leftMax, rightMax) + root.val;
    }

    // Solution from labuladong
    public int maxPathSum3(TreeNode root) {
        max = Integer.MIN_VALUE;

        if (root == null) {
            return max;
        }
        // Do I even need BFS or DFS is good enough ?
        oneSideMax(root);
        return max;
    }

    // Why I can't pass the max into parameter here ? (it always default back to the
    // init value)
    // In Java, it is not possible to pass primitives by reference. To emulate this,
    // you must pass a reference to an instance of a mutable wrapper class. (e.g.
    // wrap it in array/list)
    public int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // was wrong on this part when I tried it. I guess, because it could be -
        // (negative value) Without this, input [-3] might yield the result 0.
        int leftMax = Math.max(0, oneSideMax(root.left));
        int rightMax = Math.max(0, oneSideMax(root.right));

        // missing root.val when doing the addition;
        int pathMaxSum = root.val + leftMax + rightMax;
        max = Math.max(max, pathMaxSum);

        // the key is here, we need to select Left or Right --> go with the bigger one
        // one each branch
        // https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java/37681
        return Math.max(leftMax, rightMax) + root.val;
    }

}
