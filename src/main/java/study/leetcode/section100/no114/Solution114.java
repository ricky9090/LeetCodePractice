package study.leetcode.section100.no114;

import study.leetcode.common.TreeNode;

/**
 * <h2>Flatten Binary Tree to Linked List</h2>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <pre>
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * </pre>
 * The flattened tree should look like:
 * <pre>
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/">
 * Flatten Binary Tree to Linked List</a>
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left == null && right == null) {
            return;
        }

        // 对于TreeNode X，设左子树为L，右子树为R
        // 1. flatten(L) 将L转换为链表A
        // 2. X.left置空，X.right设置为A头节点
        // 3. A末端节点连接原右子树R  X.right -> A(A1->A2->...->An) -> R
        // 4. flatten(R) 转换右子树R

        if (left != null) {
            flatten(left);
            TreeNode middle = left;
            while (middle.right != null) {
                middle = middle.right;
            }

            root.left = null;
            root.right = left;
            middle.right = right;
        }


        if (right != null) {
            flatten(right);
        }

    }
}
