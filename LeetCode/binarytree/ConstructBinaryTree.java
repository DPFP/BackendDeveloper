public class ConstructBinaryTree {

    // Construct Binary Tree from Inorder and Postorder Traversal
    // recursive method

    int pInorder; // position inorder;
    int pPostorder; // position postorder;
    int pPreorder; // position preorderr

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
    // Construct Binary Tree from Inorder and Postorder Traversal End

    // Construct Binary Tree from Inorder and Preorder Traversal
    // recursive method
    // TODO didn't work :(
    private TreeNode buildTreeForPreAndIn(int[] preorder, int[] inorder, TreeNode end) {
        if (pPreorder > preorder.length - 1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pPreorder++]);
        if (inorder[pInorder] != root.val) {
            root.right = buildTreeForPreAndIn(preorder, inorder, root);
        }
        pInorder++;
        if ((end == null) || (inorder[pInorder] != end.val)) {
            root.left = buildTreeForPreAndIn(preorder, inorder, end);
        }

        return root;
    }

    public TreeNode buildTreeForPreAndIn(int[] preorder, int[] inorder) {
        pPreorder = 0;
        pInorder = 0;

        return buildTreeForPreAndIn(preorder, inorder, null);
    }
    // Construct Binary Tree from Inorder and Preorder Traversal End

    public static void main(String[] args) {
        ConstructBinaryTree sol = new ConstructBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        sol.buildTree(inorder, postorder).inorderTravers(root);

    }
}
