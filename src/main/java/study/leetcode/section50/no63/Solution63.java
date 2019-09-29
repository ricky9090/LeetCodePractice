package study.leetcode.section50.no63;

/**
 * <h2>Unique Paths II</h2>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * <img width="490" height="210" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png" alt="">
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * <b>Note:</b> m and n will be at most 100.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/unique-paths-ii">
 * Unique Paths II</a>
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null
                || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0) {
            return 0;
        }

        final int width = obstacleGrid[0].length;
        final int height = obstacleGrid.length;

        int[][] sumBoard = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == 0 && y == 0) {
                    if (obstacleGrid[y][x] == 1) {
                        return 0;
                    }
                    sumBoard[y][x] = 1;
                    continue;
                }

                if (obstacleGrid[y][x] == 1) {
                    sumBoard[y][x] = 0;
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
                sumBoard[y][x] = sumBoard[y][x - 1] + sumBoard[y - 1][x];
            }
        }
        return sumBoard[height - 1][width - 1];

    }
}
