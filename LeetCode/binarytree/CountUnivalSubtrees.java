public class CountUnivalSubtrees {
    int count = 0;

    // implemented solution from
    // https://algodaily.com/challenges/counting-univalued-subtrees
    public int countUnivalSubtrees(TreeNode root) {
        isUnivalSubTrees(root);
        return count;
    }

    // Method #1
    // Post-order traverse
    public boolean isUnivalSubTrees(TreeNode root) {
        // base case
        if (root == null) {
            return true;
        }

        // leaf nodes - base case
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }

        // step 1 and 2 check if left and right subtrees are univalued
        // this is the left subtree and right subtree walk of post-order traversal
        boolean isLeftUnivalued = isUnivalSubTrees(root.left);
        boolean isRightUnivalued = isUnivalSubTrees(root.right);

        // Step 3 - base case
        if (!isLeftUnivalued || !isRightUnivalued) {
            return false;
        }

        // Step 4 - check other conditions
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

    // method #1.2 (similar to #1)
    boolean is_uni(TreeNode node) {
        // base case - if the node has no children this is a univalue subtree
        if (node.left == null && node.right == null) {

            // found a univalue subtree - increment
            count++;
            return true;
        }

        boolean is_unival = true;

        // check if all of the node's children are univalue subtrees and if they have
        // the same value
        // also recursively call is_uni for children
        if (node.left != null) {
            is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
        }

        if (node.right != null) {
            is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
        }

        // return if a univalue tree exists here and increment if it does
        if (!is_unival) {
            return false;
        }
        count++;
        return true;
    }

    // method #2 -- DFS + pass parents value
    // TODO can't wrap my head around it 2021-12-20
    boolean is_valid_part(TreeNode node, int val) {

        // considered a valid subtree
        if (node == null) {
            return true;
        }

        // check if node.left and node.right are univalue subtrees of value node.val
        // note that || short circuits but | does not - both sides of the or get
        // evaluated with | so we explore all possible routes
        if (!is_valid_part(node.left, node.val) | !is_valid_part(node.right, node.val)) {
            return false;
        }

        // if it passed the last step then this a valid subtree - increment
        count++;

        // at this point we know that this node is a univalue subtree of value node.val
        // pass a boolean indicating if this is a valid subtree for the parent node
        return node.val == val;
    }

    // method #3 --
    private boolean helper(TreeNode n, int v) {
        if (n == null) {
            return true;
        }
        boolean left = helper(n.left, n.val);
        boolean right = helper(n.right, n.val);
        if (left && right) {
            count++;
            return n.val == v;
        }
        return false;
    }
}
