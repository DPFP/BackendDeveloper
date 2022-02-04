import java.util.Stack;

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

    // working solution
    public boolean isValidBST3(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val > min && root.val < max) {
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        } else {
            return false;
        }
    }

    // solution from LC official
    // use the BST with InOrder traverse
    private Integer prev;

    public boolean isValidBST4(TreeNode root) {
        prev = null;
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }

        // check everything from left
        if (!inOrder(root.left)) {
            return false;
        }

        // inOrder Traverse logic
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val; // for next round of comparsion
        // -----core logic

        return inOrder(root.right);
    }

    // Iterative solution
    // The template is worth to learn
    // https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
    public boolean isValidBST5(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // keep moving all the way to left from current root
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
