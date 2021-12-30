import java.util.HashMap;
import java.util.Stack;

public class BinaryTreeFromPostOrderAndInOrder {

    // Construct Binary Tree from Inorder and Postorder Traversal
    // recursive method I
    int pInorder; // position inorder;
    int pPostorder; // position postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;

        return buildTree(inorder, postorder, null);
    }

    // help method
    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
        if (pPostorder < 0) {
            return null;
        }

        // set the root
        // noticed the pPostorder-- (decrease the index)
        TreeNode root = new TreeNode(postorder[pPostorder--]);

        // if right node exist, create the right tree
        // check if there current root(val) is the most right of "inOrder" array
        // if not, we know there must have right
        if (inorder[pInorder] != root.val) {
            root.right = buildTree(inorder, postorder, root);
        }

        // decrease index of pInorder--
        pInorder--;

        // if left node exist, create left subtree
        if ((end == null) || (inorder[pInorder] != end.val)) {
            root.left = buildTree(inorder, postorder, end);
        }

        return root;
    }

    // recursive method II -- Easier to understand
    // (Similar to Python solution from YouTube)
    // no global variable needed;
    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        // keep track of index of inorder O(n)
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    // help method
    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]); // root index
        // left of subtree is from start...rootIndex,
        root.left = buildTreePostIn(inorder, is, ri - 1, postorder, ps, ps + ri - is - 1, hm);
        // right of subtree is from rootIndex...end
        root.right = buildTreePostIn(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, hm);

        return root;
    }
    // Construct Binary Tree from Inorder and Postorder Traversal End

    // iterative solution - begin
    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34807/Java-iterative-solution-with-explanation
    public TreeNode buildTreeIterative(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            // find the position of the top node from the inorder list ?
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }

        return root;
    }
    // iterative solution - end

    public static void main(String[] args) {
        BinaryTreeFromPostOrderAndInOrder sol = new BinaryTreeFromPostOrderAndInOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        root.inorderTravers(sol.buildTree(inorder, postorder));
        System.out.println();
        // root.inorderTravers(sol.buildTreePostIn(inorder, postorder));

    }
}
