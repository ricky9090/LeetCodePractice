package study.leetcode.p50.no19;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * <p>
 * Given n will always be valid.
 *
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/">
 * Remove Nth Node From End of List - LeetCode</a>
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        ListNode prevNode = head;
        ListNode tailNode = head;
        for (int i = 0; i < n; i++) {
            if (tailNode.next != null) {
                tailNode = tailNode.next;
            } else {
                // del head node
                return head.next;
            }
        }

        while (tailNode.next != null) {
            prevNode = prevNode.next;
            tailNode = tailNode.next;
        }
        if (n == 1) {
            prevNode.next = null;
            return head;
        }
        prevNode.next = prevNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 0; i < 9; i++) {
            tmp.next = new ListNode(i + 2);
            tmp = tmp.next;
        }
        tmp.next = null;
        ListNode q = head;
        while (q != null) {
            System.out.print(q.val + ", ");
            q = q.next;
        }
        System.out.println();

        Solution solution = new Solution();

        ListNode p = solution.removeNthFromEnd(head, 10);
        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }
    }
}
