package study.leetcode.section200.no237;

import study.leetcode.common.ListNode;

/**
 * <h2>Delete Node in a Linked List</h2>
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Given linked list -- head = [4,5,1,9]
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * </code></pre>
 * <b>Note:</b>
 * <ul>
 * <li>The linked list will have at least two elements.</li>
 * <li>All of the nodes' values will be unique.</li>
 * <li>The given node will not be the tail and it will always be a valid node of the linked list.</li>
 * <li>Do not return anything from your function.</li>
 * </ul>
 *
 * @see <a href="https://leetcode-cn.com/problems/delete-node-in-a-linked-list/">
 * Delete Node in a Linked List</a>
 */
public class Solution237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
