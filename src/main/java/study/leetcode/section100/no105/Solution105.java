package study.leetcode.section100.no105;

import study.leetcode.common.TreeNode;

/**
 * <h2>Construct Binary Tree from Preorder and Inorder Traversal</h2>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * <b>Note:</b>
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <pre><code>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * </code></pre>
 * Return the following binary tree:
 * <pre><code>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">
 * Construct Binary Tree from Preorder and Inorder Traversal</a>
 */
public class Solution105 {

    int[] preorder;
    int[] inorder;
    int[] flagInorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        this.preorder = preorder;
        this.inorder = inorder;
        flagInorder = new int[inorder.length];
        TreeNode root = findRoot(0, preorder.length - 1);
        return root;
    }

    private TreeNode findRoot(int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int rootVal = preorder[startIndex];
        TreeNode root = new TreeNode(rootVal);

        if (startIndex == endIndex) {
            return root;
        }
        findChild(root, startIndex + 1, endIndex);
        return root;
    }

    private void findChild(TreeNode root, int childStart, int childEnd) {
        int rootIndexIn = findIndexOf(root.val, inorder);
        flagInorder[rootIndexIn] = Integer.MAX_VALUE;
        int index = rootIndexIn;
        int leftCount = 0;
        while (index >= 0) {
            index -= 1;
            if (index >= 0 && flagInorder[index] != Integer.MAX_VALUE) {
                leftCount++;
            } else {
                break;
            }
        }

        root.left = findRoot(childStart, childStart + leftCount - 1);
        root.right = findRoot(childStart + leftCount, childEnd);
    }

    private int findIndexOf(int val, int[] array) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (val == array[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        Solution105 solution105 = new Solution105();
        TreeNode root = solution105.buildTree(pre, in);
        System.out.println();
    }
}
