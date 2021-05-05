
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next = null; // for leetcode 116

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

    TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    void preorderTraverse(TreeNode root) {
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

    void inorderTraversNext(TreeNode root) {
        if (root != null) {
            inorderTravers(root.left);
            System.out.println(root.next.val);
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

    int countNode(TreeNode root) {
        // base case
        if (root == null)
            return 0;
        // 自己加上子树的节点数就是整棵树的节点数
        return 1 + countNode(root.left) + countNode(root.right);
    }
}
