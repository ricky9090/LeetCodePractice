package study.leetcode.section200.no226;

import study.leetcode.common.TreeNode;

/**
 * <h2>Invert Binary Tree</h2>
 * Invert a binary tree.
 *
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/description/">
 * Invert Binary Tree - LeetCode</a>
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
