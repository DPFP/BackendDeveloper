package LeetCode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer {
    // 116. Populating Next Right Pointers in Each Node
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

    // Recurssive Solution from 2021/2/21 submission (similar to LC #2 appraoch
    // which is iterative solution)
    // probably is the eaiest understand solution so far (labuladong solution)
    // (with combination of the tree graph) 2/14/22
    public Node connect3(Node root) {
        if (root == null) {
            return root;
        }
        connectTwoNode(root.left, root.right);

        return root;
    }

    private void connectTwoNode(Node left, Node right) {
        // e.g. 2, 3
        if (left == null || right == null) {
            return;
        }

        // set the Next value
        // pre-order (from top-to-bottom appraoch)
        left.next = right;

        // share the same parent node (4,5) (6,7)
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        // not share the same parent node (5, 6) [key step]
        connectTwoNode(left.right, right.left);
    }

    // Amazaing simple recursive solution
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37472/A-simple-accepted-solution/265892
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        dfs(curr.left, curr.right);
        // cant get my mind wrap around the following line of code
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }

    // LC official soultuion #1 with BFS. Time: O(N) Space: O(N)
    // Re-tried on 2/11/2022
    public Node connect2(Node root) {
        // second approach, using the method from LC solution
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (q.size() > 0) { // while(!q.isEmpty())
            int size = q.size();

            // make sure go through every node within the same level;
            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                // have to have this check to ensure only link those within the same level;
                // first "size - 1" element
                // then connect the next pointer;
                if (i < size - 1) {
                    node.next = q.peek(); // q.peek() return to null if empty;
                }
                // Above is the key !!!

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        // the root tree has now been altered;
        return root;
    }

    // LC official soultuion #2 with using previous next pointer
    // Time: O(N)
    // Space: O(1) -- no longer need use extra DS(data structure)
    public Node connect4(Node root) {
        // LC official #2 approach, use the previous next pointer values
        if (root == null) {
            return root;
        }

        Node leftMost = root;
        while (leftMost.left != null) {
            // treat it like a linkedList
            Node head = leftMost;
            while (head != null) {
                // connection 1 : share the same parents
                head.left.next = head.right;
                // connection 2: not-shared parent
                if (head.next != null) { // MT: missing the check;
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            // move on to next level;
            leftMost = leftMost.left;
        }
        return root;
    }

    // recursive solution based the idea from appraoch #2
    private void recur(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        recur(root.left);
        recur(root.right);
    }

    public static void main(String[] args) {

    }
}
