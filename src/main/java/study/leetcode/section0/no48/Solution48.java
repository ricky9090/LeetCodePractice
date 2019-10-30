package study.leetcode.section0.no48;

/**
 * <h2>Rotate Image</h2>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * <b>Note:</b>
 * <pre>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * </pre>
 * <b>Example 1:</b>
 * <pre><code>
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 *
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/rotate-image/">
 * Rotate Image</a>
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        // 上下左右四条边界index
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int bottom = matrix.length - 1;

        /*
        通过控制四条边，不断缩小矩形边界范围到矩阵中心。
         */
        while (!end(matrix.length, left, right)) {
            rotateBorder(left, right, up, bottom, matrix);

            up++;
            bottom--;
            left++;
            right--;
        }

    }

    /**
     * 当矩形边界缩小到最小时返回true结束旋转
     */
    private boolean end(int length, int left, int right) {
        if (length % 2 == 0) {
            return right < left;
        } else {
            return right == left;
        }
    }

    /**
     * 旋转四条边的元素
     *
     * @param left   左边界index
     * @param right  右边界index
     * @param up     上边界index
     * @param bottom 下边界index
     * @param matrix 目标数组
     */
    private void rotateBorder(int left, int right, int up, int bottom, int[][] matrix) {
        for (int i = left; i < right; i++) {
            int delta = i - left;
            int tmp = matrix[up][i];
            matrix[up][i] = matrix[bottom - delta][left];
            matrix[bottom - delta][left] = matrix[bottom][right - delta];
            matrix[bottom][right - delta] = matrix[up + delta][right];
            matrix[up + delta][right] = tmp;
        }
    }
}
