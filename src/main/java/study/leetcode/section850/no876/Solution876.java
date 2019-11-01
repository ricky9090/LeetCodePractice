package study.leetcode.section850.no876;

import study.leetcode.common.ListNode;

/**
 * <h2>Middle of the Linked List</h2>
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * </code></pre>
 * <b>Note:</b>
 * <pre>
 *     The number of nodes in the given list will be between 1 and 100.
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list/">
 * Middle of the Linked List</a>
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        int count = 0;
        ListNode node = head;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        count++;
        int half = count / 2 + 1;
        ListNode result = head;
        for (int i = 1; i < half; i++) {
            result = result.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Solution876 solution876 = new Solution876();
        solution876.middleNode(a);
    }
}
