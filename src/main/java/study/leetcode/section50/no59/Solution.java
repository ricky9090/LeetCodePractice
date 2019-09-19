package study.leetcode.section50.no59;

/**
 * <h2>Spiral Matrix II</h2>
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/spiral-matrix-ii">
 * Spiral Matrix II</a>
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int numberToPlace = n * n;
        int[][] result = new int[n][n];

        final int RIGHT = 1;
        final int DOWN = 2;
        final int LEFT = 3;
        final int UP = 4;

        int direction = RIGHT;
        int hasPlaced = 0;
        int horizontalIndex = 0;
        int verticalIndex = 0;
        while (hasPlaced < numberToPlace) {
            result[verticalIndex][horizontalIndex] = hasPlaced + 1;
            hasPlaced++;
            switch (direction) {
                case RIGHT:
                    int nextRight = horizontalIndex + 1;
                    if (nextRight >= n || result[verticalIndex][nextRight] != 0) {
                        direction = DOWN;
                        verticalIndex++;
                    } else {
                        horizontalIndex++;
                    }
                    break;
                case DOWN:
                    int nextDown = verticalIndex + 1;
                    if (nextDown >= n || result[nextDown][horizontalIndex] != 0) {
                        direction = LEFT;
                        horizontalIndex--;
                    } else {
                        verticalIndex++;
                    }
                    break;
                case LEFT:
                    int nextLeft = horizontalIndex - 1;
                    if (nextLeft < 0 || result[verticalIndex][nextLeft] != 0) {
                        direction = UP;
                        verticalIndex--;
                    } else {
                        horizontalIndex--;
                    }
                    break;
                case UP:
                    int nextUp = verticalIndex - 1;
                    if (nextUp < 0 || result[nextUp][horizontalIndex] != 0) {
                        direction = RIGHT;
                        horizontalIndex++;
                    } else {
                        verticalIndex--;
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.generateMatrix(3);
        System.out.println(result);
    }
}
