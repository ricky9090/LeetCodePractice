package study.leetcode.section100.no112;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Path Sum</h2>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * <b>Note:</b> A leaf is a node with no children.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/path-sum">
 * Path Sum</a>
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        final List<String> flagList = new ArrayList<>();
        walk(sum, 0, root, flagList);

        return flagList.size() != 0;
    }

    private void walk(int sum, int lastSum, TreeNode currentNode, final List<String> flagList) {
        if (currentNode == null) {
            return;
        }
        int currentSum = lastSum + currentNode.val;
        if (currentNode.left == null && currentNode.right == null) {
            if (currentSum == sum) {
                flagList.add("");
                return;
            }
        }

        if (currentNode.left != null) {
            walk(sum, currentSum, currentNode.left, flagList);
        }
        if (currentNode.right != null) {
            walk(sum, currentSum, currentNode.right, flagList);
        }
    }
}
