public class LeetCode114 {
    // Flatten Binary Tree to Linked List
    // in place

    public void flatten(TreeNode root) {
        if (root != null) {
            // root.right = root.left;
            flatten(root.left);
            flatten(root.right);

            // postorder

            // 1, flatten left/right child tree
            TreeNode left = root.left;
            TreeNode right = root.right;

            // 2, move left tree as right tree
            root.left = null;
            root.right = left;

            // 3, link original right tree to the end of current right tree
            TreeNode p = root;
            while (p.right != null) {
                // go all the way to the "right-most" node
                p = p.right;
            }
            p.right = right;
        }
    }

    public static void main(String[] args) {
        LeetCode114 sol = new LeetCode114();

        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.left.left = new TreeNode(3);
        test.left.right = new TreeNode(4);
        test.right = new TreeNode(5);
        test.right.right = new TreeNode(6);

        // before
        // test.preorderTraverse(test);

        // after
        sol.flatten(test);
        test.preorderTraverse(test);
    }
}
