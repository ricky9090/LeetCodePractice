package study.leetcode.section50.no62;

/**
 * <h2>Unique Paths</h2>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <img width="490" height="210" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png" alt="">
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: m = 7, n = 3
 * Output: 28
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/unique-paths">
 * Unique Paths</a>
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] sumBoard = new int[m][n];
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (x == 0 && y == 0) {
                    sumBoard[y][x] = 1;
                    continue;
                }

                if (y == 0) {
                    sumBoard[y][x] = sumBoard[y][x - 1];
                    continue;
                }

                if (x == 0) {
                    sumBoard[y][x] = sumBoard[y - 1][x];
                    continue;
                }

                sumBoard[y][x] = sumBoard[y - 1][x] + sumBoard[y][x - 1];
            }
        }

        return sumBoard[m - 1][n - 1];
    }
}
