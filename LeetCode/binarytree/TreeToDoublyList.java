import java.util.Stack;

public class TreeToDoublyList {

    // 426. Convert Binary Search Tree to Sorted Doubly Linked List
    // https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

    // init approach
    public Node treeToDoublyList(Node root) {
        // You can think of the left and right pointers as synonymous to the predecessor
        // and successor pointers
        // flatten the tree ? in BST --> in order traverse
        inOrder(root);
        return root;
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        // In order
        System.out.print(" " + root.val);
        inOrder(root.right);
    }

    // Solution from Labuladong
    // recursive
    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return root;
        }

        // convert left and right
        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);

        // init the tail
        Node leftTail, rightTail;

        // from root to the middle of left/right
        // left
        if (leftHead != null) {
            leftTail = leftHead.left;
            root.left = leftTail;
            leftTail.right = root;
        } else {
            leftTail = leftHead = root;
        }

        // right
        if (rightHead != null) {
            rightTail = rightHead.left;
            root.right = rightHead;
            rightHead.left = root;
        } else {
            rightTail = rightHead = root;
        }

        // connect the most left and most right
        leftHead.left = rightTail;
        rightTail.right = leftHead;

        return leftHead;
    }

    // Java Iterative solution
    // this one seems a little bit easier to understand
    public Node treeToDoublyList3(Node root) {
        if (root == null) {
            return root;
        }
        Node dummy = new Node(0);
        Node prev = dummy;
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            // start with dummy-head (prev) -> cur
            prev.right = curr;
            // dummy head (pre) <- cur
            curr.left = prev;
            // move on to next pair (curr) & (curr.right)
            prev = curr;
            curr = curr.right;
        }

        dummy.right.left = prev;
        prev.right = dummy.right;

        return dummy.right;
    }
}
