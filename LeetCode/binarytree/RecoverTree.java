public class RecoverTree {

    // two wrong nodes
    TreeNode first = null, second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);

        // swap the value betwwn two Nodes;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // find the two spot
        // The following If check to see if there is something in the left that are
        // larger than root. As InOrder traverse will ensure prev will be the last
        // element from the left-subtree
        if (root.val < prev.val) {
            // fill the first spot
            if (first == null) {
                first = prev;
            }
            // fill the second spot
            second = root;
        }

        // set current root to prev for next iteration of comparsion
        prev = root;

        traverse(root.right);
    }
}
