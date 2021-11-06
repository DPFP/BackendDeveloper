import java.util.Stack;

public class PathSum {

    // recusrive solution
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // iterative solution
    public boolean hasPathSumI(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();

        stack.push(root);
        sums.push(sum);
        while (!stack.isEmpty() && (root != null)) {
            int value = sums.pop();
            TreeNode top = stack.pop();

            if (top.left == null && top.right == null && top.val == value) {
                return true;
            }
            if (top.right != null) {
                stack.push(top.right);
                sums.push(value - top.val);
            }
            if (top.left != null) {
                stack.push(top.left);
                sums.push(value - top.val);
            }

        }
        return false;
    }

}
