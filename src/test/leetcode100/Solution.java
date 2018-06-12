package test.leetcode100;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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