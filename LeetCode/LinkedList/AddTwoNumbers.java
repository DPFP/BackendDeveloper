package LeetCode.LinkedList;

public class AddTwoNumbers {

    // 1st try didn't really work :(
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0, b = 0;

        int power = 0;
        while (l1 != null) {
            a += l1.val * Math.pow(10, power);
            l1 = l1.next;
            power++;
        }

        power = 0;
        while (l2 != null) {
            b += l2.val * Math.pow(10, power);
            l2 = l2.next;
            power++;
        }

        char[] s = Integer.toString(a + b).toCharArray();

        ListNode res = new ListNode();
        ListNode temp = res;
        for (int i = s.length - 1; i >= 0; i--) {
            res.next = new ListNode(Character.getNumericValue(s[i]));
            res = res.next;
        }

        return temp.next;
    }

    // online discussion solution
    // https://leetcode.com/problems/add-two-numbers/discuss/1044/Java-concise-solution.
    // after debug: the idea is keep adding carry, carry % 10 will be remaining
    // digit, carry /= 10 will be carry over;
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head, p = new ListNode(0);
        head = p;

        // the carry != 0 is very important to check, means still number remaining.
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            // carry % 10 will be remaining digit,
            p.next = new ListNode(carry % 10);
            // carry /= 10 will be carry over;
            carry /= 10;
            p = p.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers sol = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        sol.addTwoNumbers2(l1, l2);

        int carry = 1000;
        System.err.println(carry /= 10);
    }
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
