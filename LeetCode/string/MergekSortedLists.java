import java.util.PriorityQueue;

public class MergekSortedLists {

    // 23 Merge K Sorted Lists https://leetcode.com/problems/merge-k-sorted-lists/
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
    // sort the linkedlist by head asc order ? and then merge ? like how to merge
    // interval ?
    // what is the brute force appraoch ? PriorityQueue ? --> keep addting

    public ListNode mergeKLists(ListNode[] lists) {
        // if(lists.length == 0){
        // return null;
        // }

        // if(lists.length == 1 && lists[0] == null){
        // return null;
        // }

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (ListNode node : lists) {
            while (node != null) {
                q.add(node.val);
                node = node.next;
            }
        }

        // do this to prevent the empty listNode
        ListNode head = new ListNode(0);
        ListNode root = head;

        while (!q.isEmpty()) {
            // System.out.print(q.poll() + " ");
            head.next = new ListNode(q.poll());
            head = head.next;
        }

        return root.next;
    }
}
