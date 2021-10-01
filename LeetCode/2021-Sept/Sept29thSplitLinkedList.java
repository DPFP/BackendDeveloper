public class Sept29thSplitLinkedList {

    public ListNode[] splitListToParts(ListNode head, int k) {
        // https://just4once.gitbooks.io/leetcode-notes/content/leetcode/linked-list/725-split-linked-list-in-parts.html
        // https://www.cnblogs.com/grandyang/p/7878548.html

        ListNode[] res = new ListNode[k];
        if (k == 1) { // if k == 1, then we just return the head
            res[0] = head;
            return res;
        }
        int size = getLength(head);
        ListNode pre = null; // pre is the last node of the first part
        for (int i = 0; i < k; i++) {
            res[i] = head; // res[i] is the head of the i-th part
            int j = size / k + (i < size % k ? 1 : 0); // j is the length of the i-th part
            while (head != null && j > 0) { // head is the current node of the i-th part
                pre = head; // pre is the last node of the first part
                head = head.next; // head is the current node of the i-th part
                j--;
            }
            if (pre != null) { // if pre is not null, then we need to break the link
                pre.next = null; // break the link
            }
        }
        return res;
    }

    private int getLength(ListNode root) {
        int len = 0;
        while (root != null) {
            len++;
            root = root.next;
        }
        return len;
    }

    public ListNode[] splitListToParts1stTry(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int count = 0;
        ListNode current = head;
        while (current.next != null) {
            if (res[count].val > 0) {
                res[count].next = current;
            } else {
                res[count] = new ListNode(current.val); // 1, 2, 3, []
            }
            res[count].next = null; // [1], [2], [3],

            if (count == k - 1) {
                count = 0;
            } else {
                count++; // 1, 2
            }
            current = current.next; // 1,2,3,4
        }
        return res;
    }

    public static void main(String[] args) {
        Sept29thSplitLinkedList sol = new Sept29thSplitLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        ListNode[] res = sol.splitListToParts(head, 3);
        for (int i = 0; i < res.length; i++) {
            ListNode cur = res[i];
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
            System.out.println();
        }

    }
}
