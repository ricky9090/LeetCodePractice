package study.leetcode.section950.no965;

import study.leetcode.common.TreeNode;

/**
 * <h2>Univalued Binary Tree</h2>
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * <img  width="300" height="200" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/29/screen-shot-2018-12-25-at-50104-pm.png"/>
 * <pre><code>
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: [2,2,2,5,2]
 * Output: false
 * </code></pre>
 * <b>Note:</b>
 * <ul>
 * <li>The number of nodes in the given tree will be in the range [1, 100].</li>
 * <li>Each node's value will be an integer in the range [0, 99].</li>
 * </ul>
 *
 * @see <a href="https://leetcode-cn.com/problems/univalued-binary-tree/">
 * Univalued Binary Tree</a>
 */
public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        int target = root.val;
        return walk(root, target);
    }

    private boolean walk(TreeNode node, int target) {
        if (node == null) {
            return true;
        }
        if (node.val == target) {
            return walk(node.left, target) && walk(node.right, target);
        } else {
            return false;
        }
    }
}
