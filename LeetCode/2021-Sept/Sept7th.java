public class Sept7th {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head; // 1
        ListNode prev = null;

        while (curr != null) {
            ListNode nextTemp = curr.next; // [hold all the remaining] 2345 - 345 - 45 - 5 - null
            curr.next = prev; // null - 1 - 2 - 3 - 4
            prev = curr; // 1 - 2 - 3 - 4 - 5
            curr = nextTemp; // remaing of chain 2345 - 345 - 45 - 5 - null
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Sept7th sept7th = new Sept7th();
        ListNode result = sept7th.reverseList(node1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
