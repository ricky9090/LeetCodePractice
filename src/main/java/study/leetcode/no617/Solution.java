package study.leetcode.no617;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node
 * will be used as the node of new tree.
 *
 * @see <a href="https://leetcode.com/problems/merge-two-binary-trees/description/">
 *     Merge Two Binary Trees - LeetCode</a>
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null) {
            TreeNode result = new TreeNode(t2.val);
            result.left = mergeTrees(null, t2.left);
            result.right = mergeTrees(null, t2.right);
            return result;
        }

        if (t2 == null) {
            TreeNode result = new TreeNode(t1.val);
            result.left = mergeTrees(t1.left, null);
            result.right = mergeTrees(t1.right, null);
            return result;
        }

        TreeNode result = new TreeNode(t1.val + t2.val);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);

        return result;
    }
}
