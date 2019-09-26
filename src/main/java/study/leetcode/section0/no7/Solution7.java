package study.leetcode.section0.no7;

/**
 * <h2>Reverse Integer</h2>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: 123
 * Output: 321
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: -123
 * Output: -321
 * </code></pre>
 * <b>Example 3:</b>
 * <pre><code>
 * Input: 120
 * Output: 21
 * </code></pre>
 * <b>Note:</b><br>
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^(31 − 1)]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-integer">
 * Reverse Integer</a>
 */
public class Solution7 {
    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }
        long result = 0;
        while (x != 0) {
            int lastNum = x % 10;
            x = x / 10;
            result = result * 10 + lastNum;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        System.out.println(solution.reverse(-2147483412));
    }
}
