package study.leetcode.section400.no429;

import study.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>N-ary Tree Level Order Traversal</h2>
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <img width="390" height="250" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/narytreeexample.png"/>
 * <p>
 * We should return its level order traversal:
 * <pre><code>
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/">
 * N-ary Tree Level Order Traversal</a>
 */
public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Node> initRootList = new ArrayList<>();
        initRootList.add(root);
        walk(initRootList, result);
        return result;
    }

    private void walk(List<Node> rootList, List<List<Integer>> result) {
        if (rootList == null || rootList.size() == 0) {
            return;
        }

        List<Integer> currentLevel = new ArrayList<>();
        List<Node> nextRootList = new ArrayList<>();
        for (Node node : rootList) {
            currentLevel.add(node.val);
            if (node.children != null) {
                nextRootList.addAll(node.children);
            }

        }
        result.add(currentLevel);
        walk(nextRootList, result);
    }
}
