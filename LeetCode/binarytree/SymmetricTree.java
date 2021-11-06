import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        // what if missing left or right ?
        // .poll() return null if empty;
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

            // Does the order matter ? Probably not;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    // using stack
    public boolean isSymmetricI2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if (root.left != null) {
            if (root.right == null) {
                return false;
            }
            stack.push(root.left);
            stack.push(root.right);
        } else if (root.right != null) {
            return false;
        }

        while (!stack.empty()) {
            // C: not even --> not mirror
            if (stack.size() % 2 != 0) {
                return false;
            }
            right = stack.pop();
            left = stack.pop();
            if (right.val != left.val)
                return false;

            // first portion of the mirror
            if (left.left != null) {
                if (right.right == null) {
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            } else if (right.right != null) {
                return false;
            }

            // second portion of the mirror
            if (left.right != null) {
                if (right.left == null) {
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            } else if (right.left != null) {
                return false;
            }
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
