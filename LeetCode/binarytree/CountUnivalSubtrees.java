public class CountUnivalSubtrees {
    int count = 0;

    // implemented solution from
    // https://algodaily.com/challenges/counting-univalued-subtrees
    public int countUnivalSubtrees(TreeNode root) {
        isUnivalSubTrees(root);
        return count;
    }

    public boolean isUnivalSubTrees(TreeNode root) {
        if (root == null) {
            return true;
        }

        // leaf nodes
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }

        // step 1 and 2 check if left and right subtrees are univalued
        // this is the left subtree and right subtree walk of post-order traversal
        boolean isLeftUnivalued = isUnivalSubTrees(root.left);
        boolean isRightUnivalued = isUnivalSubTrees(root.right);

        // 3
        if (!isLeftUnivalued || !isRightUnivalued) {
            return false;
        }

        // 4
        if (root.left != null && root.right == null) {
            if (root.val == root.left.val) {
                count++;
                return true;
            }
        } else if (root.left == null && root.right != null) {
            if (root.val == root.right.val) {
                count++;
                return true;
            }
        } else { // 5
            if (root.val == root.left.val && root.val == root.right.val) {
                count++;
                return true;
            }
        }
        // 6
        return false;
    }
}
