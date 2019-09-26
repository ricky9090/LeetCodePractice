package study.leetcode.section50.no54;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Spiral Matrix</h2>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/spiral-matrix">
 * Spiral Matrix</a>
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        final int RIGHT = 1;
        final int DOWN = 2;
        final int LEFT = 3;
        final int UP = 4;
        int width = matrix[0].length;
        int height = matrix.length;
        int direction = RIGHT;
        int[][] check = new int[height][width];
        List<Integer> result = new ArrayList<>();

        int maxStep = matrix.length * matrix[0].length;
        int x = 0;
        int y = 0;
        for (int i = 0; i < maxStep; i++) {
            result.add(matrix[y][x]);
            check[y][x] = 1;
            if (direction == RIGHT) {
                if (x + 1 >= width || check[y][x + 1] > 0) {
                    direction = DOWN;
                    y++;
                } else {
                    x++;
                }
            } else if (direction == DOWN) {
                if (y + 1 >= height || check[y + 1][x] > 0) {
                    direction = LEFT;
                    x--;
                } else {
                    y++;
                }
            } else if (direction == LEFT) {
                if (x - 1 < 0 || check[y][x - 1] > 0) {
                    direction = UP;
                    y--;
                } else {
                    x--;
                }
            } else if (direction == UP) {
                if (y - 1 < 0 || check[y - 1][x] > 0) {
                    direction = RIGHT;
                    x++;
                } else {
                    y--;
                }
            }

        }
        return result;
    }
}
