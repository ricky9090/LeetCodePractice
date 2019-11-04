package study.leetcode.section100.no129;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Sum Root to Leaf Numbers</h2>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * <b>Note:</b> A leaf is a node with no children.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/">
 * Sum Root to Leaf Numbers</a>
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> pathList = new ArrayList<>();
        sum(root, 0, pathList);
        int result = 0;
        for (Integer i : pathList) {
            result += i;
        }

        return result;
    }

    private void sum(TreeNode root, int current, List<Integer> pathList) {
        int update = root.val + current * 10;
        if (root.left == null && root.right == null) {
            pathList.add(update);
        } else if (root.left == null) {
            sum(root.right, update, pathList);
        } else if (root.right == null) {
            sum(root.left, update, pathList);
        } else {
            sum(root.right, update, pathList);
            sum(root.left, update, pathList);
        }


    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;

        Solution129 solution129 = new Solution129();
        int result = solution129.sumNumbers(a);
        System.out.println(result);
    }
}
