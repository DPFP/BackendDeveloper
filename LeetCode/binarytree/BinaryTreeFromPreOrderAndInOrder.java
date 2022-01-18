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

    // recursive method II -- most efficient, but harder to understand
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

    // from labuladong
    /* 主函数 */
    TreeNode buildTree3(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /*
     * 定义：前序遍历数组为 preorder[preStart..preEnd]，
     * 中序遍历数组为 inorder[inStart..inEnd]，
     * 构造这个二叉树并返回该二叉树的根节点
     */
    TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引 找到root在 InOrder中的位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    // From LC top discussion -- probably one of the cleanst and easier to
    // understand;
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
    public TreeNode buildTree4(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    // C: compare with labuladong, there is no "preEnd" parameter
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        // C: notice here is i<=inEnd, because the callee was using inorder.length - 1
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        // C: figure out the parameters is the key;
        // index -1 & index + 1 (split into two parts)
        // moving from [left -> <- rootIndex - 1]
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // moving from [rootIndex + 1 -> <- right] C: basically, excluded all those
        // element from left. (C: re-arrange the parameter make it a little easier to
        // understand the differences between left & right) --
        // Why " -inStart " ??? Because that is where the previous thread pointer at ?
        root.right = helper(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

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
