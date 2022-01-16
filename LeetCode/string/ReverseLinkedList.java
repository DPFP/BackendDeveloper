public class ReverseLinkedList {
    // 206 Reverse a Linked List
    // https://leetcode.com/problems/reverse-linked-list/

    // from labuladong (recursive solution)
    // https://labuladong.gitee.io/algo/2/17/17/
    public ListNode reverseList(ListNode head) {
        // base case head.next == null;
        if (head == null || head.next == null) {
            return head;
        }
        // post-order, bottom up ;

        ListNode last = reverseList(head.next);

        // C: this is the very tricky part
        head.next.next = head;
        head.next = null;

        return last;
    }

    // 9/7/2021 (Iterative solution )
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head; // current node
        while (curr != null) {
            ListNode nextTemp = curr.next; // next node
            curr.next = prev; // reverse the link
            prev = curr; // move prev to curr
            curr = nextTemp; // move curr to next
        }
        return prev;
    }

    // https://leetcode.com/problems/reverse-linked-list/discuss/1449712/Easy-C%2B%2BJavaPythonJavaScript-Explained%2BAnimated
    // good explain with animation
    public ListNode reverseList3(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode n = head.next;
            head.next = prev;
            prev = head;
            head = n;
        }
        return prev;
    }

    // Another recursive solution
    public ListNode reverseList4(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
