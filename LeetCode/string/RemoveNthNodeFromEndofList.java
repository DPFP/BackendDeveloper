public class RemoveNthNodeFromEndofList {
    // 19 Remove Nth Node From End Of List
    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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

    // solution based on labuladong
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // solution from labuladong
        ListNode fast, slow;
        fast = head;
        slow = head;

        // give the fast node a head-start of n step;
        for (int i = 0; i < n; i++) {
            // slow = slow.next;
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        // after fast had the head start, then we let fast/slow walk together;
        // then fast will be n step before slow reach to the end.
        // and assume the fast take n step back from the "End" then it will where slow
        // will be
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // here is the key, which is used to remove the nth node
        slow.next = slow.next.next;

        return head;
    }
}
