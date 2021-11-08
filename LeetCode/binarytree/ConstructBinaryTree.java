public class ConstructBinaryTree {

    // Construct Binary Tree from Inorder and Postorder Traversal
    // recursive method

    int pInorder; // position inorder;
    int pPostorder; // position postorder;

    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
        if (pPostorder < 0) {
            return null;
        }

        // set the root
        // noticed the pPostorder--
        TreeNode root = new TreeNode(postorder[pPostorder--]);

        // if right node exist, create the right tree
        if (inorder[pInorder] != root.val) {
            root.right = buildTree(inorder, postorder, root);
        }

        // decrease index of pInorder--
        pInorder--;

        // if left node exist, create left subtree
        if ((end == null) || (inorder[pInorder] != end.val)) {
            root.left = buildTree(inorder, postorder, end);
        }

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;

        return buildTree(inorder, postorder, null);
    }
    // End

    public static void main(String[] args) {

    }
}
