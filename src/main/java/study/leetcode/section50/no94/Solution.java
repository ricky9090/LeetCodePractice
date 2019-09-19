package study.leetcode.section50.no94;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * <b>Follow up:</b> Recursive solution is trivial, could you do it iteratively?
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">
 * Binary Tree Inorder Traversal</a>
 */
public class Solution {
    // recursive solution
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        if (left != null) {
            result.addAll(left);
        }
        result.add(root.val);
        if (right != null) {
            result.addAll(right);
        }

        return result;
    }
}
