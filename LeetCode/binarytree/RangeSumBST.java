public class RangeSumBST {
    // 938. Range Sum of BST
    // https://leetcode.com/problems/range-sum-of-bst/

    // initial solution (BF) not as efficient
    // O(N)
    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        // in order traverse and then add if it within range;
        if (root == null) {
            return 0;
        }

        rangeSumBST(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        rangeSumBST(root.right, low, high);

        return res;
    }

    // this one, much more efficient, as it cut the search to half by using the BST
    // property
    // O(H)
    int sum = 0;

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        // left branch excluded
        // e.g. root = 5, low = 6, that means everything will be on the right branch;
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        // right branch excluded
        // e.g. root = 10, high = 8, that means everything will be on the left branch;
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

    }
}
