
public class KthSmallestElementinBST {

    int DEPTH = 0;
    int RES = 0;

    public int kthSmallest(TreeNode root, int k) {
        // since it is BST , we need use it property. --> InOrder Traverse.
        inOrderTraverse(root, k);

        return RES;
    }

    private void inOrderTraverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inOrderTraverse(root.left, k);

        DEPTH++; // make sure increment the DEPTH before checking
        // here is the checking logic
        if (DEPTH == k) {
            RES = root.val;
        }

        inOrderTraverse(root.right, k);
    }
}
