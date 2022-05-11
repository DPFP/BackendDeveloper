public class PalindromeLinkedList {
    // 234. Palindrome Linked List

    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

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

}
