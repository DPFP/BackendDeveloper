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

    public static void main(String[] args) {

    }
}
