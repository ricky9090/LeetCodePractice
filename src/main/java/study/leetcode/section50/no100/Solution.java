package study.leetcode.section50.no100;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * @see <a href="https://leetcode.com/problems/same-tree/description/">
 * Same Tree</a>
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return walk(p, q);
    }

    public static boolean walk(TreeNode nodeFromA, TreeNode nodeFromB) {
        if (nodeFromA == null && nodeFromB == null) {
            return true;
        }
        if (nodeFromA == null || nodeFromB == null) {
            return false;
        }
        if (nodeFromA.val != nodeFromB.val) {
            return false;
        } else {
            return walk(nodeFromA.left, nodeFromB.left) && walk(nodeFromA.right, nodeFromB.right);
        }

    }
}