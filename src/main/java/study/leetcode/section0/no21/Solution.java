package study.leetcode.section0.no21;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">
 * Merge Two Sorted Lists - LeetCode</a>
 */
public class Solution {
    /**
     * merge two sorted list
     *
     * @param l1 sorted list 1
     * @param l2 sorted list 2
     * @return the head node of new list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode merged = new ListNode(-99);
        ListNode tmp = merged;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = new ListNode(l1.val);
                tmp.next.next = null;

                tmp = tmp.next;
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(l2.val);
                tmp.next.next = null;

                tmp = tmp.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            while (l1 != null) {
                tmp.next = new ListNode(l1.val);
                tmp.next.next = null;

                tmp = tmp.next;
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            while (l2 != null) {
                tmp.next = new ListNode(l2.val);
                tmp.next.next = null;

                tmp = tmp.next;
                l2 = l2.next;
            }
        }

        return merged.next;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode tmp = headA;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(6);
        tmp = tmp.next;
        tmp.next = new ListNode(7);
        tmp = tmp.next;
        tmp.next = new ListNode(9);

        ListNode headB = new ListNode(3);
        ListNode tmp2 = headB;
        tmp2.next = new ListNode(7);
        tmp2 = tmp2.next;
        tmp2.next = new ListNode(8);

        Solution solution = new Solution();
        ListNode node = solution.mergeTwoLists(headA, headB);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
