package JavaBasic.LeetCode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
    Queue<Integer> list;

    public BSTIterator(TreeNode root) {
        this.list = new LinkedList<Integer>();
        traverse(root);
    }

    public int next() {
        return list.poll();
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        this.list.add(root.val);
        traverse(root.right);
    }
}
