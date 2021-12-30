public class BinaryTreeFromPreOrderAndInOrder {

    // Construct Binary Tree from Inorder and Preorder Traversal
    int pPreorder; // position preorderr
    int pInorder;

    // recursive method I
    // didn't work because --> the left and right are wrong
    // Fixed it
    private TreeNode buildTreeForPreAndIn(int[] preorder, int[] inorder, TreeNode end) {
        if (pPreorder > preorder.length - 1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pPreorder++]);

        if (inorder[pInorder] != root.val) {
            root.left = buildTreeForPreAndIn(preorder, inorder, root);
        }

        pInorder++;

        if ((end == null) || (inorder[pInorder] != end.val)) {
            root.right = buildTreeForPreAndIn(preorder, inorder, end);
        }

        return root;
    }

    public TreeNode buildTreeForPreAndIn(int[] preorder, int[] inorder) {
        pPreorder = 0;
        pInorder = 0;

        return buildTreeForPreAndIn(preorder, inorder, null);
    }

    // recursive method II
    // come up this answer by mimic the Post/Inorder method
    int pPre;
    int pIn;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 0 || inorder.length < 0) {
            return null;
        }

        pPre = 0;
        pIn = 0;

        // return the helper method - recursively;
        return buildTree(preorder, inorder, null);
    }

    private TreeNode buildTree(int[] pre, int[] in, TreeNode end) {
        if (pPre >= pre.length) { // do i need check pIn ?
            return null;
        }

        // get the current preOrderNode and then move on to next index ->
        TreeNode root = new TreeNode(pre[pPre++]);

        // From left-right-root (post-order construction)
        // there is left sub-tree
        if (in[pIn] != root.val) {
            root.left = buildTree(pre, in, root);
        }

        // move on to next index ->
        pIn++;

        // Need understand this part better.
        if ((end == null) || (in[pIn] != end.val)) {
            root.right = buildTree(pre, in, end);
        }

        return root;
    }
    // Construct Binary Tree from Inorder and Preorder Traversal End

    public static void main(String[] args) {
        BinaryTreeFromPostOrderAndInOrder sol = new BinaryTreeFromPostOrderAndInOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        root.inorderTravers(sol.buildTree(inorder, postorder));
        System.out.println();
        // root.inorderTravers(sol.buildTreePostIn(inorder, postorder));

    }
}
