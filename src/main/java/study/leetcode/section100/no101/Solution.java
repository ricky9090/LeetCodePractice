package study.leetcode.section100.no101;

import java.util.ArrayList;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric.
 * <p>
 * But the following [1,2,2,null,3,null,3] is not.
 *
 * @see <a href="https://leetcode.com/problems/symmetric-tree/description/">
 *     Symmetric Tree - LeetCode</a>
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {

        } else {
            if (root.left == null) {
                return false;
            }
            if (root.right == null) {
                return false;
            }
        }

        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);

        boolean hasChild = true;

        int level = 1;

        // 按层展开
        while (hasChild) {
            hasChild = false;
            int orgSize = treeNodes.size();
            int start = orgSize - level;

            // 展开本层
            for (int j = start; j < orgSize; j++) {
                TreeNode node = treeNodes.get(j);
                if (node == null) {
                    treeNodes.add(null);
                    treeNodes.add(null);
                    continue;
                }
                if (node.left != null) {
                    treeNodes.add(node.left);
                    hasChild = true;
                } else {
                    treeNodes.add(null);
                }
                if (node.right != null) {
                    treeNodes.add(node.right);
                    hasChild = true;
                } else {
                    treeNodes.add(null);
                }

                // 对本层元素对称判断
                int delta = j - start;
                int left = start + delta;
                int right = orgSize - delta - 1;
                if (treeNodes.get(left) != null && treeNodes.get(right) != null) {
                    if (treeNodes.get(left).val != treeNodes.get(right).val) {
                        return false;
                    }
                } else {
                    if (treeNodes.get(left) == null) {
                        return false;
                    }
                    if (treeNodes.get(right) == null) {
                        return false;
                    }
                }
            }
            level = level * 2;// 1, 2, 4, 8, ...
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = null;
        node.left.right = new TreeNode(4);
        node.right.left = null;
        node.right.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(node));
    }
}
