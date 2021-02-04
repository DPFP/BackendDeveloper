import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {
    // Binary Tree Inorder Traversal
    // Given the root of a binary tree, return the inorder traversal of its nodes'
    // values.

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(3);
        tn.left = new TreeNode(9);
        tn.right = new TreeNode(20);
        tn.right.left = new TreeNode(15);
        tn.right.right = new TreeNode(7);

        LeetCode94 sol = new LeetCode94();
        System.out.println(sol.inorderTraversal(tn));

    }
}
