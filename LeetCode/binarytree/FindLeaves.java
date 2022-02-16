import java.util.ArrayList;
import java.util.List;

public class FindLeaves {
    // 366. Find Leaves of Binary Tree
    // https://leetcode.com/problems/find-leaves-of-binary-tree/

    // 3rd try (2/15/22)
    public List<List<Integer>> findLeaves3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        calculateLeaves(root, res);
        return res;
    }

    private int calculateLeaves(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1; // beyond leaves (null -1 )
        }
        int h = 1 + Math.max(calculateLeaves(root.left, res), calculateLeaves(root.right, res));
        // post-order traverses (bottom up)
        if (res.size() == h) {
            res.add(new ArrayList<>());
        }
        res.get(h).add(root.val);
        // reset/remove the leaves
        root.left = root.right = null;

        return h;
    }

    // solution from labuladong suggestion
    public List<List<Integer>> findLeaves(TreeNode root) {
        // move the list from Global variable to local seems speed up the performance ?
        List<List<Integer>> res = new ArrayList<>();
        maxDepth(root, res);
        return res;
    }

    int maxDepth(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return 0;
        }

        // find the deepest/longest leave node
        // of current level
        int h = Math.max(maxDepth(root.left, res), maxDepth(root.right, res)) + 1;

        // post order traverse
        if (res.size() < h) { // haven't ful-fill all level yet;
            // keep inrease the size/level of the list
            res.add(new ArrayList<>());
        }
        // put all leaves which were in the same level to the list in reverse order;
        res.get(h - 1).add(root.val);

        // Missing this step -- it seems requird from the problem
        root.left = root.right = null;

        return h;
    }

    // LeetCode Official Approach 2: DFS (Depth-First Search) without sorting
    // notice the differences: I like this one better; a little bit more clear
    private List<List<Integer>> solution;

    public List<List<Integer>> findLeaves2(TreeNode root) {
        this.solution = new ArrayList<>();
        getHeight(root);
        return this.solution;
    }

    private int getHeight(TreeNode root) {
        // return -1 for null nodes
        if (root == null) {
            return -1;
        }
        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // post-order traverse to get the actual height
        // from leave (height 0,1,2 --> root level)
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        // start from leave - height 0 -> add the most outer layer of leaves
        if (this.solution.size() == currHeight) {
            this.solution.add(new ArrayList<>());
        }
        this.solution.get(currHeight).add(root.val);

        // Missing this step --
        // it seems requird from the problem which is remove the leaves
        root.left = root.right = null;

        return currHeight;
    }

}
