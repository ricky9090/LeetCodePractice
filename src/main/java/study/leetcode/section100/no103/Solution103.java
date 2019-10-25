package study.leetcode.section100.no103;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Binary Tree Zigzag Level Order Traversal</h2>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
 * return its zigzag level order traversal as:
 * <pre><code>
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">
 * Binary Tree Zigzag Level Order Traversal</a>
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> initialList = new ArrayList<>();
        initialList.add(root);
        walk(initialList, false, result);

        return result;
    }

    private void walk(List<TreeNode> nodeList, boolean reverseOrder, final List<List<Integer>> result) {
        if (nodeList == null || nodeList.size() == 0) {
            return;
        }

        List<TreeNode> nextLevel = new ArrayList<>();
        List<Integer> currentData = new ArrayList<>();
        for (TreeNode node : nodeList) {
            if (node.left != null) {
                nextLevel.add(node.left);
            }

            if (node.right != null) {
                nextLevel.add(node.right);
            }

            if (reverseOrder) {
                currentData.add(0, node.val);
            } else {
                currentData.add(node.val);
            }
        }

        result.add(currentData);
        boolean nextOrder = !reverseOrder;
        walk(nextLevel, nextOrder, result);
    }
}
