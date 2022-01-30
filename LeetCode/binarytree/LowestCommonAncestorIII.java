import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorIII {
    // 1650. Lowest Common Ancestor of a Binary Tree III
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/

    // WRONG Try
    public Node lowestCommonAncestor(Node p, Node q) {
        // brute force solution
        if (p == null || q == null) {
            return null;
        }

        Set<Node> parents = new HashSet<>();
        parents.add(p);
        parents.add(q);

        while (p.parent != null) {
            parents.add(p.parent);
            p = p.parent;
        }

        while (q.parent != null) {
            if (parents.contains(q.parent)) {
                return q.parent;
            } else {
                parents.add(q.parent);
            }
            q = q.parent;
        }

        return null;
    }

    // Correct version -- look/compare the val instead of the actual node
    // O(h) time and space where h is the height of the given binary tree.
    // Easier to understand
    public Node lowestCommonAncestor2(Node p, Node q) {
        Set<Integer> seen = new HashSet<>();
        // Walk upwards from p and mark nodes as seen.
        while (p != null) {
            seen.add(p.val);
            p = p.parent;
        }
        // Walk upwards from q until we encounter an already seen node.
        while (q != null) {
            if (seen.contains(q.val))
                return q; // We found the LCA.
            q = q.parent;
        }
        return null;
    }

    // Genius solution
    // Exactly the same problem with 160
    // the concept of two runners on the circle track.
    // https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!/165648
    public Node lowestCommonAncestor3(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }

    // another really good solution
    public Node lowestCommonAncestor4(Node p, Node q) {
        final Set<Node> set = new HashSet<>();
        while (p != null && set.add(p))
            p = p.parent;
        while (q != null && !set.contains(q))
            q = q.parent;
        return q;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _parent) {
            val = _val;
            left = _left;
            right = _right;
            parent = _parent;
        }
    }
}
