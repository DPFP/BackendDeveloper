import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
     * = left; this.right = right; } }
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 1, I know it gonna to use Queue
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int levelNum = queue.size(); // 1

            for (int i = 0; i < levelNum; i++) { // what current in queue need be process
                TreeNode current = queue.poll(); // -- or remove();
                curLevel.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left); // ++
                }
                if (current.right != null) {
                    queue.offer(current.right); // ++
                }
            }
            res.add(curLevel);
        }
        return res;
    }

    // LeetCode 104 - Easy -- Iteratively
    public int maxDepthI(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size(); // noticed this part that getting the queue.size();
            // you can't replace level with queue.size(); --> as the queue size will be
            // change within the for loop
            for (int i = 0; i < level; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // LeetCode 104 - Easy -- Recursively
    public int maxDepthR(TreeNode root) {
        findTheMaxDepthTopDown(root, 1);
        return answer;
    }

    // top-down appraoch
    private int answer;

    void findTheMaxDepthTopDown(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }

        findTheMaxDepthTopDown(root.left, depth + 1);
        findTheMaxDepthTopDown(root.right, depth + 1);
    }

    // Use stack Iteratively (模版)
    // https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            // left
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // parent
            root = stack.pop();
            list.add(root.val);

            // right
            root = root.right;

        }
        return list;
    }
}
