package study.leetcode.section100.no107;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h2>Binary Tree Level Order Traversal II</h2>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * <b>For example:</b>
 * <pre><code>
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its bottom-up level order traversal as:
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii">
 * Binary Tree Level Order Traversal II</a>
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> initList = new ArrayList<>();
        initList.add(root);
        walk(initList, result);

        return result;
    }

    private void walk(List<TreeNode> nodes, List<List<Integer>> resultList) {
        if (nodes == null || nodes.size() == 0) {
            return;
        }

        List<Integer> currentLevel = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                currentLevel.add(node.val);
                if (node.left != null) {
                    nextNodes.add(node.left);
                }
                if (node.right != null) {
                    nextNodes.add(node.right);
                }
            }
        }
        resultList.add(0, currentLevel);
        walk(nextNodes, resultList);
    }
}
