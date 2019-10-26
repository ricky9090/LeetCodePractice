package study.leetcode.section0.no24;

import study.leetcode.common.ListNode;

/**
 * <h2>Swap Nodes in Pairs</h2>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may <b>not</b> modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/swap-nodes-in-pairs/">
 * Swap Nodes in Pairs</a>
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = head;
        ListNode tmp1 = tmpHead;
        ListNode tmp2 = head;
        ListNode tmp3 = head.next;

        while (tmp2 != null && tmp3 != null) {
            tmp1.next = tmp3;
            tmp2.next = tmp3.next;
            tmp3.next = tmp2;

            // step 2
            tmp3 = tmp2;
            tmp2 = tmp1.next;
            if (tmp1 != null) {
                tmp1 = tmp1.next;
            }
            if (tmp1 != null) {
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                tmp2 = tmp2.next;
            }
            if (tmp2 != null) {
                tmp2 = tmp2.next;
            }
            if (tmp3 != null) {
                tmp3 = tmp3.next;
            }
            if (tmp3 != null) {
                tmp3 = tmp3.next;
            }
        }

        return tmpHead.next;
    }
}
