import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    // LC 101. Symmetric Tree recursively
    public boolean isSymmetricR(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        // here is the key to the mirror !!!
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // LC 101. Symmetric Tree Iteratively
    // this is using queue. can also use stack
    public boolean isSymmetricI(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree sol = new SymmetricTree();

        System.out.println(sol.isSymmetricI(root));
    }
}
