package study.leetcode226;

/**
 * Invert a binary tree.
 *
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/description/">
 *     Invert Binary Tree - LeetCode</a>
 */
public class Solution {
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
