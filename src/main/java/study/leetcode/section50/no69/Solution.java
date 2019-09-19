package study.leetcode.section50.no69;

/**
 * <h2>Sqrt(x)</h2>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: 4
 * Output: 2
 * </code></pre>
 *
 * <b>Example 2:</b>
 * <pre><code>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/sqrtx">
 * Sqrt(x)</a>
 */
public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        double guess = x / 2;

        boolean needGuess = true;
        while (needGuess) {
            double tmp = (guess + x / guess) / 2;
            if (Math.abs(guess - tmp) < 0.5) {
                needGuess = false;
            }
            guess = tmp;
        }

        //System.out.println("double value of sqrt " + x + " is " + guess);
        return (int) guess;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2));
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(9));
    }
}
