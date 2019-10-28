package study.leetcode.section0.no40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * <h2>Combination Sum II</h2>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * <b>Note:</b>
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * <b>Example 1:</b>
 * <pre><code>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/combination-sum-ii/">
 * Combination Sum II</a>
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);  // 首先对数组排序，以便剪枝
        solve(candidates, 0, target, new ArrayList<Integer>(), result);

        return result;
    }

    /**
     * 类似于No39，增加了重复路径与元素的判断。
     * 避免多次计算同一元素，或是多条路径值相同
     */
    private void solve(int[] candidates, int index, int remain, List<Integer> currentList, List<List<Integer>> result) {
        if (remain == 0) { // 由于index会+1，先判断remain，避免漏掉最后一个元素的结果
            result.add(currentList);
            return;
        }
        if (index >= candidates.length || remain < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i - 1] == candidates[i]) { // 排序后相邻元素相等，只遍历第一个，后面的舍去，避免路径上的值相等
                continue;
            }
            int tmp = candidates[i];
            int nextRemain = remain - tmp;
            if (nextRemain < 0) { // 新的剩余值已经小于0，没必要遍历后面元素了
                continue;
            }
            if (nextRemain > 0 && nextRemain < tmp) { // 当前元素大于新的剩余值，没必要继续遍历了
                continue;
            }

            List<Integer> nextList = new ArrayList<>();
            nextList.addAll(currentList);
            nextList.add(tmp);
            solve(candidates, i + 1, nextRemain, nextList, result); // 避免同一元素多次计算，i+1

        }
    }

    public static void main(String[] args) {
        int[] test = {10, 1, 2, 7, 6, 1, 5};  // {1,1,2,5,6,7,10}
        int[] test2 = {2, 5, 2, 1, 2};
        Solution40 solution40 = new Solution40();
        List<List<Integer>> result = solution40.combinationSum2(test2, 5);
        System.out.println(result);
    }
}
