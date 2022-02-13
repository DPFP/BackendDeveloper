package Meta.LC_Tag;

public class RemoveDuplicatesInPlace {

    // can't figure it out
    public int removeDuplicates(int[] nums) {
        int FLAG = 101;

        int len = nums.length;

        int prev = nums[0];
        int index = 1;

        while (index < len && nums[index] == prev) {
            // find duplicated
            nums[index] = FLAG;
            index++;
            prev = nums[index]; // 1,
            index++;
        }

        return 0;
    }

    // Very precise two pointer appraoch from labuladong
    // https://labuladong.gitee.io/algo/2/21/68/
    public int removeDuplicates2(int[] nums) {
        // use two pointers (fast/slow ) or sliding window
        if (nums.length == 0) {
            return 0;
        }

        int fast = 0;
        int slow = 0;
        int len = nums.length;

        while (fast < len) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // swap the element
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // index + 1;
        return slow + 1;
    }

    // similar problem LC 83 Remove Duplicates from Sorted List
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        // similar to 26 use Two pointer (fast/slow)
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            // find discrepancy
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast]
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }

        slow.next = null; // cut off all the duplicated value
        return head;
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
