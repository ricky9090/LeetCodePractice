package study.leetcode.section200.no216;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Combination Sum III</h2>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * <b>Note:</b>
 * <pre>
 *     All numbers will be positive integers.
 *     The solution set must not contain duplicate combinations.
 * </pre>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/combination-sum-iii/">
 * Combination Sum III</a>
 */
public class Solution216 {
    /**
     * @param k 结果数组元素个数
     * @param n 目标数字
     * @return 所有符合要求的数组
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0 || n == 0) {
            return result;
        }

        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        solve(k, candidates, n, 0, new ArrayList<Integer>(), result);

        return result;
    }

    private void solve(final int howMany, final int[] candidates,
                       int remain, int currentIndex, List<Integer> currentList,
                       List<List<Integer>> result) {
        if (remain == 0 && currentList.size() == howMany) {
            result.add(currentList);
        }
        if (remain == 0) {
            return;
        }

        if (currentIndex >= candidates.length || currentList.size() >= howMany) {
            return;
        }

        for (int i = currentIndex; i < candidates.length; i++) {
            int tmp = candidates[i];
            int nextRemain = remain - tmp;
            if (nextRemain < 0) {
                continue;
            }
            if (nextRemain > 0 && nextRemain < tmp) {
                continue;
            }

            List<Integer> nextList = new ArrayList<>();
            nextList.addAll(currentList);
            nextList.add(tmp);
            solve(howMany, candidates, nextRemain, i + 1, nextList, result);
        }
    }

    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        List<List<Integer>> result = solution216.combinationSum3(3, 7);
        System.out.println(result);
    }
}
