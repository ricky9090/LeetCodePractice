package study.leetcode.section200.no203;

import study.leetcode.common.ListNode;

/**
 * <h2>Remove Linked List Elements</h2>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/remove-linked-list-elements">
 * Remove Linked List Elements</a>
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val && head.next == null) {
            return null;
        }

        ListNode prev = new ListNode(val);
        prev.next = head;
        ListNode flag = prev;
        while (flag.next != null) {
            if (flag.next.val == val) {
                ListNode toRemove = flag.next;
                flag.next = toRemove.next;
                toRemove.next = null;
            } else {
                flag = flag.next;
            }
        }

        return prev.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution203 solution203 = new Solution203();
        ListNode result = solution203.removeElements(node1, 2);
        System.out.println();
    }
}
