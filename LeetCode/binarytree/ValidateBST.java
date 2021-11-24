public class ValidateBST {

    // https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

    // WRONG version [2,2,2] (not looking at local max/min)
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val > root.val || root.right != null && root.val > root.right.val) {
            return false;
        }

        if (!isValidBST(root.left) || !isValidBST(root.right)) {
            return false;
        }

        return true;
    }

    // Failed on CASE [-2147483648,-2147483648]
    // -2^31 <= Node.val <= 2^31 - 1
    public boolean isValidBSTR(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return isValidBST(root.left, min, root.val - 1) && isValidBST(root.right, root.val + 1, max);
    }

    public static void main(String[] args) {

    }
}
