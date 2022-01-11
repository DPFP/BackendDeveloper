import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {
    // 987.Vertical Order Traversal of a Binary Tree
    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

    // First try mimic LC314 --> Not working. because the order mattesr (top -
    // bottom, small to large)
    // the main problem is the sorting, which throw things off.

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, List<Integer>> colMap = new HashMap<>();
        Queue<TreeNode> nq = new LinkedList<>(); // node queue
        nq.offer(root);

        Queue<Integer> cq = new LinkedList<>(); // col queue
        cq.offer(0); // start from the middle as root

        // left,right boundries
        int left = 0;
        int right = 0;

        while (!nq.isEmpty()) {
            // don't need the following
            // int size = nq.size();
            TreeNode cur = nq.poll();
            Integer col = cq.poll();

            colMap.putIfAbsent(col, new ArrayList<Integer>());
            colMap.get(col).add(cur.val);

            if (cur.left != null) {
                nq.offer(cur.left);
                cq.offer(col - 1);
                left = Math.min(left, col - 1);
            }

            if (cur.right != null) {
                nq.offer(cur.right);
                cq.offer(col + 1);
                right = Math.max(right, col + 1);
            }
        }

        for (int i = left; i <= right; i++) {
            // need sort the value --> why PQ is not working here?
            Collections.sort(colMap.get(i));
            res.add(colMap.get(i));
        }

        return res;
    }

    // could also borrow the following data structure
    class Pair {
        TreeNode node;
        int x; // horizontal
        int y; // depth

        Pair(TreeNode n, int x, int y) {
            node = n;
            this.x = x;
            this.y = y;
        }
    }

    // I believe is one of the best solution
    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231125/Java-HashMap-and-TreeMap-and-PriorityQueue-Solution
    // TODO Need time to digest it approach
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
    int minX = 0; // left
    int maxX = 0; // right

    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        // pre-order traverse to populate the Map & min/max
        helper(root, 0, 0);
        // after the loop, everthing we need will be save to the map;

        // then we just need to loop through find the result we need;
        List<List<Integer>> vertical = new ArrayList<>();

        // i -- col index (left to right)
        for (int i = minX; i <= maxX; i++) {
            List<Integer> level = new ArrayList<>();
            // loop to get all the treeMap keySet (col from left to right)
            for (int key : map.get(i).keySet()) {
                // then get row for each level(col)
                // "key" --> top to bottom
                while (!(map.get(i).get(key)).isEmpty()) {
                    level.add(map.get(i).get(key).poll());
                }
            }
            vertical.add(level);
        }
        return vertical;
    }

    private void helper(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }

        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);

        map.putIfAbsent(x, new TreeMap<Integer, PriorityQueue<Integer>>());
        map.get(x).putIfAbsent(y, new PriorityQueue<Integer>());
        map.get(x).get(y).add(node.val);

        // here is the key part. y-vertical always move down. (+1)
        // x move left -1, x move right +1
        helper(node.left, x - 1, y + 1);
        helper(node.right, x + 1, y + 1);
    }

}
