import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {

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

                // make sure get the right most
                if (i == size - 1) {
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
}
