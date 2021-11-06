public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum) {
            return true;
        }

        return isTarget(root, 0, targetSum);
    }

    private boolean isTarget(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return sum == targetSum;
        }

        sum += root.val;
        isTarget(root.left, sum, targetSum);
        isTarget(root.right, sum, targetSum);

        // what should the return be ?
        return sum == targetSum;
    }
}
