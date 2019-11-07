package study.leetcode.section750.no783;

import study.leetcode.common.TreeNode;

/**
 * <h2>Minimum Distance Between BST Nodes</h2>
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 * <p>
 * <b>Example :</b>
 * <pre><code>
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * </code></pre>
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * <pre>
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 * </pre>
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * <p>
 * <b>Note:</b>
 * <pre>
 *     The size of the BST will be between 2 and 100.
 *     The BST is always valid, each node's value is an integer, and each node's value is different.
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/">
 * Minimum Distance Between BST Nodes</a>
 */
public class Solution783 {
    TreeNode parent;
    int min;

    public int minDiffInBST(TreeNode root) {
        min = Integer.MAX_VALUE;
        findMin(root);
        return min;
    }

    private void findMin(TreeNode node) {
        if (node == null) {
            return;
        }
        findMin(node.left);

        if (parent != null) {
            int x = Math.abs(node.val - parent.val);
            min = Math.min(min, x);
        }
        parent = node;
        findMin(node.right);
    }
}
