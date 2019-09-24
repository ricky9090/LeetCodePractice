package study.leetcode.section50.no64;

/**
 * <h2>Minimum Path Sum</h2>
 * Given a <b>m</b> x <b>n</b> grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * <b>Note:</b> You can only move either down or right at any point in time.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum">Minimum Path Sum</a>
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sumGrid = new int[m][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (x == 0 && y == 0) { // left-up corner
                    sumGrid[y][x] = grid[0][0];
                    continue;
                }

                if (x - 1 < 0) { // left edge
                    sumGrid[y][x] = sumGrid[y - 1][x] + grid[y][x]; // only from above
                    continue;
                }

                if (y - 1 < 0) { // up edge
                    sumGrid[y][x] = sumGrid[y][x - 1] + grid[y][x]; // only from left
                    continue;
                }
                int fromAbove = sumGrid[y - 1][x] + grid[y][x];
                int fromLeft = sumGrid[y][x - 1] + grid[y][x];
                sumGrid[y][x] = Math.min(fromAbove, fromLeft);  // choose min
            }
        }

        return sumGrid[m - 1][n - 1];

    }

    public static void main(String[] args) {
        int[][] test = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Solution64 solution = new Solution64();
        System.out.println(solution.minPathSum(test));
    }
}
