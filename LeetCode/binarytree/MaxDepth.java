import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    // 104. Maximum Depth of Binary Tree
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    // Key: post-order traverse (from bottom-up)

    // 2022-01-04 worked solution:
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMax(root, 0);
    }

    private int getMax(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }

        int left = getMax(node.left, depth);
        int right = getMax(node.right, depth);

        return Math.max(left, right) + 1;
    }

    // This is enough for the solution; -- bottom up approach
    // post-order;
    public int maxDepth2(TreeNode root) {

        if (root == null) {
            // reach leaf nodes (return from bottom up )
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // This another approach which require additional parameter -- top-down appraoch
    // pre-order;
    int answer = 0;

    public int maxDepth3(TreeNode root) {
        getMaxDepth(root, 1);
        return answer;
    }

    private void getMaxDepth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // we know we reached to the leaf / bottom of the branch
        if (node.left == null && node.right == null) {
            answer = Math.max(answer, depth);
        }

        // From top of the root, keep going down +1 depth;
        getMaxDepth(node.left, depth + 1);
        getMaxDepth(node.right, depth + 1);
    }

    // Iterative solution using Queue
    public int maxDepth4(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth++;
        }

        return depth;

    }

}
