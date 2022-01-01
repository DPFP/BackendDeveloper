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

    // Correct Answer -- Noticed the differences !!!
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) { // means reached the leaf node -- bottom of the tree.
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // 后序遍历位置顺便计算最大直径 --
        // key point: have to count both left + right
        max = Math.max(max, left + right);

        // why still need do this part ? This is the actual depth of each node
        return Math.max(left, right) + 1;
    }
}
