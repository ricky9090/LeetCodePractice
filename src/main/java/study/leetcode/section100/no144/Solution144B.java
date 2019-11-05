package study.leetcode.section100.no144;

import study.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution144B {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> walkList = new ArrayList<>();
        walkList.add(root);

        while(walkList.size() != 0) {
            TreeNode target = walkList.get(walkList.size() - 1);
            walkList.remove(walkList.size() - 1);
            result.add(target.val);
            if (target.right != null) {
                walkList.add(target.right);
            }
            if (target.left != null) {
                walkList.add(target.left);
            }
        }
        return result;
    }
}
