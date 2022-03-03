package JavaBasic.LeetCode.binarytree;

import java.util.LinkedList;

public class BinaryTreeSerialize {
    String SP = ",";
    String NULL = "#";

    // https://mp.weixin.qq.com/s/DVX2A1ha4xSecEXLxW_UsA

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // BFS or any other method to traverse -- this using pre-order traverse
        StringBuilder sb = new StringBuilder();

        if (root == null) {
            return sb.toString();
        }
        preOrder(root, sb);

        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SP);
            return;
        }

        // make sure append(SP)
        sb.append(root.val).append(SP);

        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // here is the bigger question
        LinkedList<String> nodes = new LinkedList<>();

        for (String s : data.split(SP)) {
            nodes.add(s);
        }

        return buildTree(nodes);
    }

    TreeNode buildTree(LinkedList<String> nodes) {
        // exits strategy ?
        if (nodes.isEmpty()) {
            return null;
        }

        // grab the first from the list -- which is the root
        // because we are doing pre-order traverse
        // 状态转化的是nodes - 每次使用都在减少.
        String first = nodes.removeFirst(); // remove first for PreOrder Encode

        // Base Case - exit strategy
        // here need to make sure check both null and empty string
        if (first.equals(NULL) || first.equals("")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(first));

        // then keep going for the left-right child nodes
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

        return root;
    }
    /// End of Pre-order

    // Begin Post-order Method (Labuladong solution)
    // Encodes a tree to a single string. (review: 1/14/22, 2/15/22)
    public String serialize2(TreeNode root) {
        // Now try post-order traverse
        StringBuilder sb = new StringBuilder();
        encode(root, sb); // notice it didn't return anything

        return sb.toString();
    }

    private void encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SP);
            return;
        }

        encode(root.left, sb);
        encode(root.right, sb);

        // post-order traverse
        sb.append(root.val).append(SP);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if (data.length() <= 0) {
            return null;
        }

        // Key part: convert the String to list of "nodes"
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SP)) {
            nodes.add(s);
        }

        return decode(nodes);
    }

    TreeNode decode(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        // This will consume the LinkedList like a queue from (right to left);
        // removeLast() for postOrder encode
        String last = nodes.removeLast(); // or use nodes.pollLast();

        if (last.equals(NULL) || last.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));

        // now is the tricky part, we have to start from RIGHT;
        root.right = decode(nodes);
        root.left = decode(nodes);

        return root;
    }
    // End Post-order
}
