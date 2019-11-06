package study.leetcode.section200.no231;

/**
 * <h2>Power of Two</h2>
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 *     Input: 1
 *     Output: true
 *     Explanation: 20 = 1
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 *     Input: 16
 *     Output: true
 *     Explanation: 24 = 16
 * </code></pre>
 * <b>Example 3:</b>
 * <pre><code>
 *     Input: 218
 *     Output: false
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/power-of-two/">
 * Power of Two</a>
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        int remain = n;
        while (remain != 1) {
            int a = remain % 2;
            if (a != 0) {
                return false;
            }
            remain = remain / 2;
        }
        return true;

    }

    public static void main(String[] args) {
        Solution231 solution231 = new Solution231();
        System.out.println(solution231.isPowerOfTwo(1));
        System.out.println(solution231.isPowerOfTwo(8));
        System.out.println(solution231.isPowerOfTwo(9));
        System.out.println(solution231.isPowerOfTwo(16));
        System.out.println(solution231.isPowerOfTwo(218));
    }
}
