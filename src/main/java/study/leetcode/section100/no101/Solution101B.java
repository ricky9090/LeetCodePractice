package study.leetcode.section100.no101;

import study.leetcode.common.TreeNode;

/**
 * <h2>Symmetric Tree</h2>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric.
 * <p>
 * But the following [1,2,2,null,3,null,3] is not.
 *
 * @see <a href="https://leetcode.com/problems/symmetric-tree/description/">
 * Symmetric Tree - LeetCode</a>
 */
public class Solution101B {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetricEqual(root.left, root.right);
    }

    private boolean symmetricEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        boolean leftEquals = symmetricEqual(left.left, right.right);
        boolean rightEquals = symmetricEqual(left.right, right.left);
        return leftEquals && rightEquals;
    }
}
