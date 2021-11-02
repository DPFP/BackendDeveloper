import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraverse {
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
}
