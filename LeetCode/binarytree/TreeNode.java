public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void preorderTraverse(TreeNode root) {
        // pre-oorder
        if (root != null) {
            System.out.println(root.val);
            preorderTraverse(root.left);
            preorderTraverse(root.right);
        }
    }

    void inorderTravers(TreeNode root) {
        if (root != null) {
            inorderTravers(root.left);
            System.out.println(root.val);
            inorderTravers(root.right);
        }
    }

    void postorderTravers(TreeNode root) {
        if (root != null) {
            postorderTravers(root.left);
            postorderTravers(root.right);
            System.out.println(root.val);
        }
    }
}
