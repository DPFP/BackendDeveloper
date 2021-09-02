
public class LeetCode116 {
    // Populate each next pointer to point to its next right node. If there is no
    // next right node, the next pointer should be set to NULL.

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }

        connectTwoNode(root.left, root.right);

        return root;
    }

    private void connectTwoNode(TreeNode left, TreeNode right) {
        // e.g. 2, 3
        if (left == null || right == null) {
            return;
        }

        // set the Next value
        left.next = right;

        // share the same parent node (4,5) (6,7)
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        // not the same parent node (5, 6) [key step]
        connectTwoNode(left.right, right.left);
    }

    public static void main(String[] args) {
        LeetCode116 sol = new LeetCode116();

        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.left.left = new TreeNode(4);
        test.left.right = new TreeNode(5);
        test.right = new TreeNode(3);
        test.right.left = new TreeNode(6);
        test.right.right = new TreeNode(7);

        sol.connect(test);

        // test.inorderTraversNext(test);
    }
}
