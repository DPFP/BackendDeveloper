import java.util.LinkedList;
import java.util.Queue;

public class IsSameTree {
    // 100. Same Tree
    // https://leetcode.com/problems/same-tree/

    // First try -- wrong answer
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p != null || q != null) {
            return p.val == q.val;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Correct solution
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        // can't be both equal to null at this point
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }

    // further simplify
    public boolean isSameTree3(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        // Neither of them are null
        if (p.val != q.val) {
            return false;
        }

        return isSameTree3(p.left, q.left) && isSameTree3(p.right, q.right);
    }

    // Iterative solution
    public boolean isSameTree4(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();

            if (l == null && r == null) {
                continue;
            } else if (l == null || r == null || l.val != r.val) {
                return false;
            }

            queue.add(l.left);
            queue.add(r.left);

            queue.add(l.right);
            queue.add(r.right);
        }

        return true;
    }
}
