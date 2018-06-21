package study.leetcode104;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from
 * the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 *
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/description/">
 * Maximum Depth of Binary Tree - LeetCode</a>
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int n = countLevel(root, 1);
        return n;
    }

    private int countLevel(TreeNode node, int currentLevel) {
        if (node == null) {
            return currentLevel - 1;
        }
        if (node.left == null && node.right == null) {
            return currentLevel;
        }
        int left = countLevel(node.left, currentLevel + 1);
        int right = countLevel(node.right, currentLevel + 1);
        if (left >= right) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        Solution solution = new Solution();
        int result = solution.maxDepth(root);

        System.out.println(result);
    }
}
