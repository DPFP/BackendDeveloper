public class DiameterOfBinaryTree {
    // 543. Diameter of Binary Tree
    // https://leetcode.com/problems/diameter-of-binary-tree/

    int max = 0;

    // WRONG Answer !!
    public int diameterOfBinaryTree0(TreeNode root) {
        if (root == null) {
            return max;
        }

        int left = Math.max(diameterOfBinaryTree0(root.left), max);
        int right = Math.max(diameterOfBinaryTree0(root.right), max);

        return Math.max(left, right) + 1;
    }

    // WRONG Answer - 2nd try (2/15/22)
    public int diameterOfBinaryTree3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return depth(root, 0);
    }

    private int depth(TreeNode root, int d) {
        if (root == null) {
            return d;
        }

        int left = depth(root.left, d + 1);
        int right = depth(root.right, d + 1);

        return Math.max(left, right) + 1;
    }

    // Correct Answer -- Noticed the differences !!!
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    // this still an post-order(bottom up -- from 0 + 1)
    private int maxDepth(TreeNode root) {
        if (root == null) { // means reached the leaf node -- bottom of the tree.
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // 后序遍历位置顺便计算最大直径 --
        // key point: have to count both left + right
        // Step 2: update the state/value
        max = Math.max(max, left + right);

        // why still need do this part ? This is the actual depth of each level
        // Step 3: make decision pick the branch.
        return Math.max(left, right) + 1; // this is choice between left & right side for each call
    }
}
