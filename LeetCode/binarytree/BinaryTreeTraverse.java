import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraverse {
    private int answer;

    // top-down appraoch
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

    // bottom-up approach
    void findTheMaxDepthBottomUp(TreeNode root) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // root.val
        // root.left
        // root.right
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        // recursive
        // preorderTraverse(root, result);

        // iteratively
        result = preorderTraverseI(root);

        return result;
    }

    // PreOrder Traverse
    // recursive solution
    void preorderTraverse(TreeNode root, List<Integer> value) {
        if (root != null) {
            value.add(root.val);
            preorderTraverse(root.left, value);
            preorderTraverse(root.right, value);
        }
    }

    // iteratively (key)
    List<Integer> preorderTraverseI(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            root = stack.pop();
            result.add(root.val);

            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return result;
    }

    // InOrder Traversal
    // recursive
    void inroderTraversalR(TreeNode root, List<Integer> res) {
        if (root != null) {
            inroderTraversalR(root.left, res);
            res.add(root.val);
            inroderTraversalR(root.right, res);
        }
    }

    // iteratively
    List<Integer> inroderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            // get everything from left node;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); // left
            res.add(root.val); // root
            root = root.right; // right
        }
        return res;
    }

    void postOrderTraversalR(TreeNode root, List<Integer> res) {
        if (root != null) {
            postOrderTraversalR(root.left, res);
            postOrderTraversalR(root.right, res);
            res.add(root.val);
        }
    }

    List<Integer> postOrderTraversalI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            root = stack.pop();

            // always added to the front
            res.add(0, root.val); // O(n), if use LinkedList it will be O(1)

            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeTraverse sol = new BinaryTreeTraverse();
        for (int i : sol.postOrderTraversalI(root)) {
            System.out.print(i + " ");
        }

        // test max depth
        sol.answer = 0;
        sol.findTheMaxDepthTopDown(root, 0);
        System.out.println(sol.answer);
    }
}
