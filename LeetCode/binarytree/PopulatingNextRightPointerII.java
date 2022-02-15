package LeetCode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointerII {

    // 117. Populating Next Right Pointers in Each Node II
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

    // probably is one of the best solution
    public Node connect(Node root) {
        // BFS
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // need do the following if we care about the level
            // otherwise, we just delt with each individual element
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                if (i < size - 1) { // be careful here !!! anything before the end of the element
                    cur.next = q.peek();
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // level++;
        }

        return root;
    }
}
