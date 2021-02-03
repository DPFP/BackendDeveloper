public class LeetCode105 {
    // problem: Given preorder and inorder traversal of a tree, construct the binary
    // tree.

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode result = null;

        return result;
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(3);
        tn.left = new TreeNode(9);
        tn.right = new TreeNode(20);
        tn.right.left = new TreeNode(15);
        tn.right.right = new TreeNode(7);

        System.out.println("preorder:");
        tn.preorderTraverse(tn);
        System.out.println("inorder:");
        tn.inorderTravers(tn);
        System.out.println("postorder:");
        tn.postorderTravers(tn);

    }
}
