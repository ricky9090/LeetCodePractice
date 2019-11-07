package study.leetcode.section650.no700;

import study.leetcode.common.TreeNode;

/**
 * <h2>Search in a Binary Search Tree</h2>
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * <p>
 * For example,
 * <pre>
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * And the value to search: 2
 * </pre>
 * You should return this subtree:
 * <pre>
 *       2
 *      / \
 *     1   3
 * </pre>
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 * <p>
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 *
 * @see <a href="https://leetcode-cn.com/problems/search-in-a-binary-search-tree/">
 * Search in a Binary Search Tree</a>
 */
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
