import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestor {

    // Solution:
    // https://mp.weixin.qq.com/s/9RKzBcr3I592spAsuMH45g

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null) {
            return null;
        }

        if (root == p || root == q) { // dont forget here.
            return root;
        }

        // recursion -- post-order (this is the key )
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // general case(s)
        // or using the All-in-one
        // return left == null ? right : right == null ? left : root;

        // For Post-order, here is the part handle the "root" aka. parent node

        // #1: if p & q were nodes of root
        if (left != null && right != null) {
            return root;
        }

        // #2: if p & q were not part of root
        if (left == null && right == null) {
            return null;
        }

        // #3: if one of the p or q belong to root
        // if in the left then return left, if not, then it must in the right
        return left == null ? right : left;
    }

    // Iterative solution
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
