package study.leetcode.section50.no77;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Combinations</h2>
 * Given two integers n and k, return all possible combinations of k numbers out of <i>1 ... n</i>.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/combinations/">
 * Combinations</a>
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k == 0) {
            return result;
        }

        solve(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }

    private void solve(int right, int howMany, int left, List<Integer> currentList, List<List<Integer>> result) {
        if (currentList.size() == howMany) {  // left会有大于right的情况，先判断列表长度
            result.add(currentList);
            return;
        }
        if (left > right) {
            return;
        }

        for (int i = left; i <= right; i++) {
            List<Integer> nextList = new ArrayList<>();
            nextList.addAll(currentList);
            nextList.add(i);
            if (right - i < howMany - nextList.size()) { // 待搜索的元素个数不够了，省略
                continue;
            }
            solve(right, howMany, i + 1, nextList, result);
        }
    }
}
