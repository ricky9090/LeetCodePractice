package study.leetcode.section100.no141;

import study.leetcode.common.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/description/">
 *     Linked List Cycle - LeetCode</a>
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode start = head;
        ListNode tail = head;

        if (start.next == null) {
            return false;
        }
        if (start.next == start) {
            return true;
        }

        tail = start.next.next;
        while(start != tail) {
            if (start == null || tail== null || tail.next == null) {
                return false;
            }
            start = start.next;
            tail = tail.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = null;

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));
    }
}
