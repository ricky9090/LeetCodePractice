package study.leetcode.section100.no102;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Binary Tree Level Order Traversal</h2>
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <pre><code>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </code></pre>
 * return its level order traversal as:
 * <pre><code>
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">
 * Binary Tree Level Order Traversal</a>
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> initialList = new ArrayList<>();
        initialList.add(root);
        walk(initialList, result);
        return result;
    }

    private void walk(List<TreeNode> nodeList, final List<List<Integer>> result) {
        if (nodeList == null || nodeList.size() == 0) {
            return;
        }


        List<TreeNode> nextLevelList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        for (TreeNode node : nodeList) {
            if (node.left != null) {
                nextLevelList.add(node.left);
            }
            if (node.right != null) {
                nextLevelList.add(node.right);
            }
            numberList.add(node.val);
        }

        result.add(numberList);

        walk(nextLevelList, result);
    }
}
