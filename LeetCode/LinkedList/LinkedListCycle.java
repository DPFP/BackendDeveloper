public class LinkedListCycle {

    // 141. Linked List Cycle
    // https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            // this means, fast has already went to the "End" without running into the slow
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
