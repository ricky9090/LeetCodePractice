package study.leetcode2;

/**
 * You are given two <strong>non-empty</strong> linked lists representing two non-negative integers.
 * The digits are stored in <strong>reverse order</strong> and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @see <a href="https://leetcode.com/problems/add-two-numbers/description/">
 * Add Two Numbers - LeetCode</a>
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aNode = l1,
                bNode = l2;

        ListNode result = new ListNode(0);
        ListNode resultToReturn = result;
        ListNode last = null;
        int carry = 0;
        while (aNode != null && bNode != null) {
            int n = aNode.val + bNode.val;
            if (carry == 1) {
                n += 1;
                carry = 0;
            }
            if (n > 9) {
                carry = 1;
                result.val = (n - 10);
            } else {
                result.val = n;
            }

            result.next = new ListNode(0);
            last = result;
            result = result.next;

            aNode = aNode.next;
            bNode = bNode.next;
        }

        while (aNode != null) {
            int n = 0;
            if (carry == 1) {
                n++;
                carry = 0;
            }
            n += aNode.val;
            if (n > 9) {
                carry = 1;
                result.val = (n - 10);
            } else {
                result.val = n;
            }

            result.next = new ListNode(0);
            last = result;
            result = result.next;
            aNode = aNode.next;
        }

        while (bNode != null) {
            int n = 0;
            if (carry == 1) {
                n++;
                carry = 0;
            }
            n += bNode.val;
            if (n > 9) {
                carry = 1;
                result.val = (n - 10);
            } else {
                result.val = n;
            }
            result.next = new ListNode(0);
            last = result;
            result = result.next;
            bNode = bNode.next;
        }

        if (carry == 1) {
            result.val++;
            carry = 0;
        }

        if (result.val == 0) {
            last.next = null;
        }

        if (last.val > 9) {
            last.next = new ListNode(1);
            last.val -= 10;
        }

        return resultToReturn;
    }

    public static void main(String[] args) {
        ListNode l1;
        ListNode l2;
        //l1 = new ListNode(2);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);

        //l2 = new ListNode(5);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);

        l1 = new ListNode(2);
        l2 = new ListNode(8);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        Solution test = new Solution();
        ListNode result = test.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
