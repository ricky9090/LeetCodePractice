package study.leetcode.section150.no172;

/**
 * <h2>Factorial Trailing Zeroes</h2>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/factorial-trailing-zeroes/">
 * Factorial Trailing Zeroes</a>
 */
public class Solution172 {
    public int trailingZeroes(int n) {
        int tmp = n;
        int result = 0;
        while (tmp >= 5) {
            result = tmp / 5 + result;
            tmp = tmp / 5;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution172 solution172 = new Solution172();
        System.out.println(solution172.trailingZeroes(3));
        System.out.println(solution172.trailingZeroes(5));
        System.out.println(solution172.trailingZeroes(30));
        System.out.println(solution172.trailingZeroes(50));
    }
}
