import java.util.HashMap;

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

    // recursive method II -- Easier to understand
    // (Similar to Python solution from YouTube)

    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        // keep track of index of inorder O(n)
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]); // root index

        // left of subtree is from start...rootIndex,
        root.left = buildTreePostIn(inorder, is, ri - 1, postorder, ps, ps + ri - is - 1, hm);

        // right of subtree is from rootIndex...end
        root.right = buildTreePostIn(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, hm);

        return root;
    }

    // Construct Binary Tree from Inorder and Postorder Traversal End

    // Construct Binary Tree from Inorder and Preorder Traversal

    int pPreorder; // position preorderr

    // recursive method I
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

    // recursive method II

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

        root.inorderTravers(sol.buildTree(inorder, postorder));
        System.out.println();
        root.inorderTravers(sol.buildTreePostIn(inorder, postorder));

    }
}
