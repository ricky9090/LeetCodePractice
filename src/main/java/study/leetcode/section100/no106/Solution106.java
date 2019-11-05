package study.leetcode.section100.no106;

import study.leetcode.common.TreeNode;

/**
 * <h2>Construct Binary Tree from Inorder and Postorder Traversal</h2>
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * <b>Note:</b>
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <pre>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 *
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">
 * Construct Binary Tree from Inorder and Postorder Traversal</a>
 */
public class Solution106 {

    int[] inorderArray;
    int[] postorderArray;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        inorderArray = inorder;
        postorderArray = postorder;

        int[] flagArray = new int[inorder.length];
        return build(postorder.length - 1, postorder.length - 2, 0, flagArray);
    }

    private TreeNode build(int rootIndex, int childStart, int childEnd, int[] flagArray) {
        if (rootIndex < 0) {
            return null;
        }
        int rootVal = postorderArray[rootIndex];
        int rootIndexInorder = findIndex(rootVal, inorderArray);
        flagArray[rootIndexInorder] = 1;

        int right = 0;
        int rightIndex = rootIndexInorder + 1;
        while (rightIndex < flagArray.length && flagArray[rightIndex] == 0) {
            right++;
            rightIndex++;
        }

        TreeNode root = new TreeNode(rootVal);
        if (childStart < childEnd) {
            return root;
        }
        int childLen = childStart - childEnd + 1;
        if (right > 0) {
            root.right = build(rootIndex - 1, rootIndex - 2, rootIndex - right, flagArray);
        }
        if (childLen - right > 0) {
            root.left = build(rootIndex - right - 1, rootIndex - right - 2, childEnd, flagArray);
        }

        return root;
    }

    private int findIndex(int x, int[] array) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] inorder = {2, 1};
        int[] postorder = {2, 1};
        Solution106 solution106 = new Solution106();
        TreeNode root = solution106.buildTree(inorder, postorder);
        System.out.println();
    }
}
