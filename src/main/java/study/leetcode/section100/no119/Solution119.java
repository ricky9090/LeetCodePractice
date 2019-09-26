package study.leetcode.section100.no119;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Pascal's Triangle II</h2>
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: 3
 * Output: [1,3,3,1]
 * </code></pre>
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle-ii">
 * Pascal's Triangle II</a>
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>(rowIndex);
        // 生成第0行，只有1
        result.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            result.add(0);
        }
        // 从第1行到K行迭代
        generate(rowIndex, 1, result);
        return result;
    }

    private void generate(int totalRow, int currentRow, List<Integer> result) {
        if (currentRow > totalRow) {
            return;
        }

        int t = 1;
        for (int i = 1; i < currentRow + 1; i++) {
            int sum = t + result.get(i);
            t = result.get(i);
            result.set(i, sum);
        }
        generate(totalRow, currentRow + 1, result);
    }

    public static void main(String[] args) {
        Solution119 solution119 = new Solution119();
        System.out.println(solution119.getRow(5));
    }
}
