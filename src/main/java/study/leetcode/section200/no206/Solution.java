package study.leetcode.section200.no206;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * <p>
 * Output: 5->4->3->2->1->NULL
 *
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/description/">
 *     Reverse Linked List - LeetCode</a>
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode first = new ListNode(0);
        ListNode second = head.next;

        while (head != null) {
            head.next = first.next;
            first.next = head;
            head = second;
            if (second == null) {
                break;
            }
            second = second.next;
        }
        return first.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode tmp = head;
        for (int i = 5; i < 20; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        Solution solution = new Solution();
        ListNode result = solution.reverseList(head);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
    }
}
