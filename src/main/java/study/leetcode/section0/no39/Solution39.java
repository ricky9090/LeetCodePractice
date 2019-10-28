package study.leetcode.section0.no39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h2>Combination Sum</h2>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <pre>
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 * </pre>
 *
 * <b>Example 1:</b>
 * <pre><code>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/combination-sum/submissions/">
 * Combination Sum</a>
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);  // 排列数组，便于剪枝
        solve(candidates, 0, target, new ArrayList<Integer>(), result);

        return result;
    }

    /**
     * 递归调用，搜索列表。利用remain标记当前分支结果，当remain = 0时，搜索结束
     * 剪枝策略仅在数组已排序情况下生效
     *
     * @param candidates  给定的候选元素数组，需从小至大排列
     * @param index       当前路径起始元素的index
     * @param remain      当前剩余数值 <= target
     * @param currentList 当前路径结果
     * @param result      最终结果数组
     */
    private void solve(int[] candidates, int index, int remain, List<Integer> currentList, List<List<Integer>> result) {
        if (index >= candidates.length || remain < 0) {
            return;
        }
        if (remain == 0) {  // 余下值为0，即得到target，添加到最终结果中
            result.add(currentList);
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int tmp = candidates[i];
            int nextRemain = remain - tmp;
            if (nextRemain < 0) { // 剪枝。新的余下值已经小于0，没有必要再搜索更大的元素了
                continue;
            }
            if (nextRemain < tmp && nextRemain > 0) { // 剪枝。新的余下值已经小于首元素，没有必要搜索后面更大的元素
                continue;
            }
            List<Integer> nextList = new ArrayList<>();
            nextList.addAll(currentList);
            nextList.add(tmp);
            solve(candidates, i, nextRemain, nextList, result);
        }
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 5};
        Solution39 solution39 = new Solution39();
        List<List<Integer>> result = solution39.combinationSum(test, 8);
        System.out.println(result);
    }
}
