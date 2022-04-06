public class CopyListWithRandomPointer {
    // 138. Copy List with Random Pointer
    // https://leetcode.com/problems/copy-list-with-random-pointer/

    // Video solution: https://www.youtube.com/watch?v=EHpS2TBfWQg&t=3s

    // solution from
    // https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)/42652
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        // 1
        Node c = head;

        // 2 Insert each node's copy right after it, already copy .label
        while (c != null) {
            Node next = c.next;
            c.next = new Node(c.val);
            c.next.next = next;
            c = next;
        }

        // 3 Set each copy's .random
        c = head;
        while (c != null) {
            if (c.random != null) {
                c.next.random = c.random.next;
            }
            c = c.next.next;
        }

        // 4 Separate the copied list from the original, (re)setting every .next
        c = head;
        Node copyHead = head.next;
        Node copy = copyHead;
        while (copy.next != null) {
            c.next = c.next.next;
            c = c.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }
        c.next = c.next.next;

        return copyHead;
    }

    public static void main(String[] args) {

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
