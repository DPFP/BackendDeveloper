import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {
    // 199. Binary Tree Right Side View
    // https://leetcode.com/problems/binary-tree-right-side-view/

    // #1 - Use BFS search
    // not the best answer, as the space/time are not that great. but solved it with
    // first try
    public List<Integer> rightSideView(TreeNode root) {
        // labuladong Tips: BFS (the last element --> right)

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result; // root ?
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (i == size - 1) { // get the right most
                    // i == 0 will get left most view (the first)
                    result.add(cur.val);
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return result;
    }

    // very smart discussion solution from LC
    // (1) the traverse of the tree is NOT standard pre-order traverse. It checks
    // the RIGHT node first and then the LEFT
    // (2) the line to check currDepth == result.size() makes sure the first element
    // of that level will be added to the result list
    // (3) if reverse the visit order, that is first LEFT and then RIGHT, it will
    // return the left view of the tree.

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        calculate(root, res, 0);

        return res;
    }

    private void calculate(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(root.val);
        }

        calculate(root.right, res, depth + 1); // notice it checking the right first !!!
        calculate(root.left, res, depth + 1);
    }
}
