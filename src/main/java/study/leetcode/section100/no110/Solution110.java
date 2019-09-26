package study.leetcode.section100.no110;

import study.leetcode.common.TreeNode;

/**
 * <h2>Balanced Binary Tree</h2>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Return true.
 * </code></pre>
 * <br>
 * <b>Example 2:</b>
 * <pre><code>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * Return false.
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/balanced-binary-tree">
 * Balanced Binary Tree</a>
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int diff = Math.abs(maxDepth(root.left) - maxDepth(root.right));
        return (diff < 2) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
