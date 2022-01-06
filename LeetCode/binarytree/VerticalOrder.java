import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> colMap = new HashMap<>();
        Queue<TreeNode> nq = new LinkedList<>(); // nodeQueue
        Queue<Integer> cq = new LinkedList<>(); // colQueue

        // boundries
        int left = 0;
        int right = 0;

        nq.offer(root);
        cq.offer(0); // ??

        while (!nq.isEmpty()) {
            TreeNode cur = nq.poll();
            int col = cq.poll();

            // this can be changed to putIfAbsent();
            // map.putIfAbsent(col, new ArrayList<>());
            if (!colMap.containsKey(col)) {
                colMap.put(col, new ArrayList<Integer>());
            }

            colMap.get(col).add(cur.val);

            if (cur.left != null) {
                nq.offer(cur.left);
                cq.offer(col - 1);
                left = Math.min(left, col - 1); // ?
            }

            if (cur.right != null) {
                nq.offer(cur.right);
                cq.offer(col + 1);
                right = Math.max(right, col + 1); // ?
            }
        }

        for (int i = left; i <= right; i++) {
            res.add(colMap.get(i));
        }

        return res;
    }
}
