public class ReverseLinkedList {
    class ListNode {
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

    // 2/9/2022 updated version II -- reverse first N nodes
    // https://leetcode.com/problems/reverse-linked-list-ii/
    ListNode successor = null; // tail

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // record the n+1 th node
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor; // connect to the tail (no longer null in the previous case)

        return last;
    }

    // 2/9/2022 updated version III -- reverse between n & m
    // https://labuladong.gitee.io/algo/2/17/17/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            // then same as reverseN
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);

        return head;
    }

    // 9/7/2021 (Iterative solution )
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head; // current node
        while (curr != null) {
            // 1, save the next node (because we gonna break the link)
            ListNode nextTemp = curr.next;
            // 2, break/reverse the link -
            // point the next node to previous node (null at the begining)
            curr.next = prev;
            prev = curr; // move prev to curr node
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

}
