public class LowestCommonAncestor {

    // Solution:
    // https://mp.weixin.qq.com/s/9RKzBcr3I592spAsuMH45g

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        // recursion -- post-order (this is the key )
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // general case(s)
        // or using the All-in-one
        // return left == null ? right : right == null ? left : root;

        // For Post-order, here is the part handle the "root" aka. parent node

        // #1: if p & q were nodes of root
        if (left != null && right != null) {
            return root;
        }

        // #2: if p & q were not part of root
        if (left == null && right == null) {
            return null;
        }

        // #3: if one of the p or q belong to root
        // if in the left then return left, if not, then it must in the right
        return left == null ? right : left;

    }
}
