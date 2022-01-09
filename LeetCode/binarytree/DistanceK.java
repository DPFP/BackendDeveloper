import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DistanceK {
    // 863. All Nodes Distance K in Binary Tree
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

    // initial approach try -- stuck on 2nd step
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 1st, BFS find the target
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size(); // when do we need check the size ?
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.val == target.val) {
                    // found the target value
                    System.out.println("find it " + cur.val + " at level " + level);
                    found = true;
                    // 2nd, BFS start from the target to seek - k distance away of nodes (level)
                    // how to deal with it parent ?
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            System.out.println(level);

            level++;
        }

        return res;
    }

    // 2nd try with suggestion from Labuladong
    Map<Integer, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // 0, keep track of their parents;
        traverseParnt(root, null);

        // 1st, BFS find the target

        Queue<TreeNode> q = new LinkedList<>();
        // KEY noticed here is offer target, not root !!! (this is where it begain)
        q.offer(target);

        // Missing the visited set;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(target.val);

        int level = 0;

        // use level <= k to futher reduce calculation.
        while (!q.isEmpty() && level <= k) {
            int size = q.size(); // when do we need check the size ?
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (level == k) {
                    res.add(cur.val);
                }

                // KEY part that I missed.
                // grab it parent node
                TreeNode parentNode = parent.get(cur.val);
                // also add the parent node to the queue
                if (parentNode != null && !visited.contains(parentNode.val)) {
                    visited.add(parentNode.val);
                    q.offer(parentNode);
                }
                // ---------------------

                if (cur.left != null && !visited.contains(cur.left.val)) {
                    visited.add(cur.left.val);
                    q.offer(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right.val)) {
                    visited.add(cur.right.val);
                    q.offer(cur.right);
                }
            }
            System.out.println(level);
            level++;
        }

        return res;
    }

    // pre order traverse
    private void traverseParnt(TreeNode root, TreeNode parentNode) {
        if (root == null) {
            return;
        }

        parent.put(root.val, parentNode);

        traverseParnt(root.left, root);
        traverseParnt(root.right, root);
    }

    // Recursive solution
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143798/1ms-beat-100-simple-Java-dfs-with(without)-hashmap-including-explanation
    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use
    // it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null)
            return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null)
            return;
        if (map.containsKey(root))
            length = map.get(root);
        if (length == K)
            res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }
}
