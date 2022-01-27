public class SubtreeofAnotherTree {

    // 572. Subtree of Another Tree
    // https://leetcode.com/problems/subtree-of-another-tree/
    // solution with help from discussion
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == subRoot;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        // return isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
        // Made the same Fucking mistake again.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
