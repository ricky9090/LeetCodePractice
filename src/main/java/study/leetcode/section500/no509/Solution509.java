package study.leetcode.section500.no509;

/**
 * <h2>Fibonacci Number</h2>
 * The Fibonacci numbers, commonly denoted F(n) form a sequence,
 * called the Fibonacci sequence, such that each number is the sum of
 * the two preceding ones, starting from 0 and 1. That is,
 * <pre>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * </pre>
 * Given N, calculate F(N).
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * </code></pre>
 * <b>Example 3:</b>
 * <pre><code>
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * </code></pre>
 * <b>Note:</b>
 * <p>
 * 0 ≤ N ≤ 30.
 *
 * @see <a href="https://leetcode-cn.com/problems/fibonacci-number/">
 * Fibonacci Number</a>
 */
public class Solution509 {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        int[] result = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            if (i == 0) {
                result[i] = 0;
                continue;
            }
            if (i == 1) {
                result[i] = 1;
                continue;
            }
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[result.length - 1];
    }

    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        System.out.println(solution509.fib(0));
        System.out.println(solution509.fib(1));
        System.out.println(solution509.fib(2));
        System.out.println(solution509.fib(3));
        System.out.println(solution509.fib(4));
        System.out.println(solution509.fib(5));

    }
}
