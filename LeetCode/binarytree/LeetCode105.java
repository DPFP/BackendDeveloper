public class LeetCode105 {
    // problem: Given preorder and inorder traversal of a tree, construct the binary
    // tree.

    // e.g.
    // preorder = [3,9,20,15,7]
    // inorder = [9,3,15,20,7]

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode result = null;

        // root
        TreeNode currRoot = new TreeNode(preorder[0]);

        // left
        TreeNode currLeft = new TreeNode(inorder[0]);

        // right
        TreeNode currRight = new TreeNode();

        return result;
    }

    // online solution
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        // establish new tree with the Root
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        // find the index
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        //
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        //
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
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
