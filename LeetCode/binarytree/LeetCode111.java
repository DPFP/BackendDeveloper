import java.util.LinkedList;
import java.util.Queue;

public class LeetCode111 {
    // Given a binary tree, find its minimum depth.
    // The minimum depth is the number of nodes along the shortest path from the
    // root node down to the nearest leaf node.
    // C: keyword "shortest path" --> BFS

    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;

        if (root == null) {
            return depth;
        }

        q.offer(root);
        depth++;

        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                //C: get the value and remove it 
                TreeNode cur = q.poll(); 
                if(cur.left == null && cur.right == null){
                    return depth;  //or depth++ ? 
                }
                
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(3);
        test.left = new TreeNode(9);

        test.right = new TreeNode(20);
        test.right.left = new TreeNode(15);
        test.right.right = new TreeNode(7);

        LeetCode111 sol = new LeetCode111();

        System.out.println(sol.minDepth(test));
    }
}
