package study.leetcode.section600.no637;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Average of Levels in Binary Tree</h2>
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * </code></pre>
 * <b>Note:</b>
 * <pre>
 *     The range of node's value is in the range of 32-bit signed integer.
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/">
 * Average of Levels in Binary Tree</a>
 */
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> initRootList = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        initRootList.add(root);
        level(initRootList, result);
        return result;
    }

    private void level(List<TreeNode> rootList, List<Double> result) {
        if (rootList == null || rootList.size() == 0) {
            return;
        }

        List<TreeNode> nextLevel = new ArrayList<>();
        double levelSum = 0;
        for (TreeNode node : rootList) {
            levelSum += node.val;
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        result.add(levelSum / rootList.size());
        level(nextLevel, result);
    }
}
