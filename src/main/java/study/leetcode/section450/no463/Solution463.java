package study.leetcode.section450.no463;

/**
 * <h2>Island Perimeter</h2>
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * </code></pre>
 * <p>
 * <img width="200" height="200" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/island.png" alt="">
 * <p>
 *
 * @see <a href="https://leetcode-cn.com/problems/island-perimeter">
 * Island Perimeter</a>
 */
public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        final int height = grid.length;
        final int width = grid[0].length;

        int perimeter = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid[y][x] == 0) {
                    continue;
                }

                perimeter = perimeter + calculate(width, height, x, y, grid);
            }
        }
        return perimeter;
    }

    private int calculate(int width, int height, int xIndex, int yIndex, int[][] grid) {
        int leftIndex = xIndex - 1;
        int rightIndex = xIndex + 1;
        int upIndex = yIndex - 1;
        int downIndex = yIndex + 1;

        int sum = 0;
        if (leftIndex >= 0 && grid[yIndex][leftIndex] == 1) {
            sum++;
        }

        if (upIndex >= 0 && grid[upIndex][xIndex] == 1) {
            sum++;
        }

        if (rightIndex < width && grid[yIndex][rightIndex] == 1) {
            sum++;
        }

        if (downIndex < height && grid[downIndex][xIndex] == 1) {
            sum++;
        }
        return 4 - sum;
    }

    public static void main(String[] args) {
        int[][] test = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        Solution463 solution = new Solution463();
        System.out.println(solution.islandPerimeter(test)); // 16
    }
}
