package study.leetcode.section100.no108;

import study.leetcode.common.TreeNode;

/**
 * <h2>Convert Sorted Array to Binary Search Tree</h2>
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree">
 * Convert Sorted Array to Binary Search Tree</a>
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }

        TreeNode root = generateTree(0, nums.length - 1, nums);
        return root;
    }

    private TreeNode generateTree(int leftIndex, int rightIndex, int[] nums) {
        if (leftIndex > rightIndex) {
            return null;
        }

        int middleIndex = (rightIndex + leftIndex) / 2;

        TreeNode parent = new TreeNode(nums[middleIndex]);
        TreeNode left = generateTree(leftIndex, middleIndex - 1, nums);
        TreeNode right = generateTree(middleIndex + 1, rightIndex, nums);
        parent.left = left;
        parent.right = right;
        return parent;
    }
}
