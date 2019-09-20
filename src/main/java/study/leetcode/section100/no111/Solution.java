package study.leetcode.section100.no111;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Minimum Depth of Binary Tree</h2>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * <b>Note:</b> A leaf is a node with no children.
 *
 * <b>Example:</b>
 * <pre><code>
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its minimum depth = 2.
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree">
 * Minimum Depth of Binary Tree</a>
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        return walk(1, nodeList);
    }

    private int walk(int currentLevel, List<TreeNode> nodes) {
        List<TreeNode> nextNodeList = new ArrayList<>();
        for (TreeNode node: nodes) {
            if (node == null) {
                continue;
            }
            if (node.left == null && node.right == null) {  // 叶子节点需左右均为空
                return currentLevel;
            }
            nextNodeList.add(node.left);
            nextNodeList.add(node.right);
        }

        int nextLevel = currentLevel + 1;
        return walk(nextLevel, nextNodeList);
    }
}
