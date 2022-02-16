import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    // 103. Binary Tree Zigzag Level Order Traversal
    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    // first approach -- learn from LC 102.
    // WRONG didn't work, because there are some logic error.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // keep track of the level mode % 2 --> odd / even
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean turn = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                curLevel.add(cur.val);

                if (turn) {
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                }
                turn = !turn;
            }

            res.add(curLevel);
        }

        return res;
    }

    // Correct version
    public List<List<Integer>> zigzagLevelOrde2(TreeNode root) {
        // keep track of the level mode % 2 --> odd / even
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean turn = true; // default turn=true, from left to right;

        while (!q.isEmpty()) {
            int size = q.size();

            LinkedList<Integer> curLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                // start from right (last)
                if (turn) {
                    curLevel.addLast(cur.val);
                } else {
                    curLevel.addFirst(cur.val);
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            turn = !turn;
            res.add(curLevel);
        }

        return res;
    }

    // 3rd try
    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean turn = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> curRes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (turn) {
                    // curRes.addLast(cur.val); (no need to specify)
                    curRes.add(cur.val); // default add to the end of queue;
                } else {
                    curRes.addFirst(cur.val); // opposite
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            turn = !turn;
            res.add(curRes);
        }

        return res;
    }
}
