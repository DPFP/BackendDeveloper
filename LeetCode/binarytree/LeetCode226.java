
public class LeetCode226 {
    // Invert a binary tree.

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        LeetCode226 sol = new LeetCode226();

        TreeNode test = new TreeNode(4);
        test.left = new TreeNode(2);
        test.left.left = new TreeNode(1);
        test.left.right = new TreeNode(3);
        test.right = new TreeNode(7);
        test.right.left = new TreeNode(6);
        test.right.right = new TreeNode(9);

        System.out.println("origin: in order ");
        test.inorderTravers(test);

        sol.invertTree(test);

        System.out.println("invert: in order ");
        test.inorderTravers(test);

        // System.out.println(test.countNode(test));
    }
}
