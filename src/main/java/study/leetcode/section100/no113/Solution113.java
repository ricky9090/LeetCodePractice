package study.leetcode.section100.no113;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Path Sum II</h2>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
 *  /  \    / \
 * 7    2  5   1
 *
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/path-sum-ii/">
 * Path Sum II</a>
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> initPath = new ArrayList<>();
        calculate(root, initPath, 0, sum, result);
        return result;
    }

    private void calculate(TreeNode node, List<Integer> path, int sum, int target, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        int val = node.val;
        int nextSum = sum + val;
        List<Integer> nextPath = new ArrayList<>();
        nextPath.addAll(path);
        nextPath.add(val);
        if (node.left == null && node.right == null && nextSum == target) {
            result.add(nextPath);
            return;
        }
        if (node.left != null) {
            calculate(node.left, nextPath, nextSum, target, result);
        }
        if (node.right != null) {
            calculate(node.right, nextPath, nextSum, target, result);
        }
    }
}
