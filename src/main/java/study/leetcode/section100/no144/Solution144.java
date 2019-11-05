package study.leetcode.section100.no144;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Binary Tree Preorder Traversal</h2>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 * </code></pre>
 * <b>Follow up:</b> Recursive solution is trivial, could you do it iteratively?
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-preorder-traversal/">
 * Binary Tree Preorder Traversal</a>
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        walk(root, result);
        return result;
    }

    private void walk(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        if (node.left != null) {
            walk(node.left, result);
        }
        if (node.right != null) {
            walk(node.right, result);
        }
    }
}
