
public class LeetCode654 {
    // https://leetcode.com/problems/maximum-binary-tree/

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        // 1,find the max value and it index (key step)
        int maxVal = Integer.MIN_VALUE;
        int index = -1; // here is the key step that I missed
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }

        // 2, create the tree
        TreeNode root = new TreeNode(maxVal);

        // 3, split to left and right
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;

    }

    public static void main(String[] args) {
        LeetCode654 sol = new LeetCode654();

        int[] test = { 3, 2, 1, 6, 0, 5 };

        TreeNode result = sol.constructMaximumBinaryTree(test);

        result.inorderTravers(result);

    }
}
