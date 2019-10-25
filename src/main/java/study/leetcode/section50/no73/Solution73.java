package study.leetcode.section50.no73;

/**
 * <h2>Set Matrix Zeroes</h2>
 * Given a <b>m x n</b> matrix, if an element is 0, set its entire row and column to 0.
 * Do it <b>in-place</b>.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * </code></pre>
 * Follow up:
 * <pre>
 *     A straight forward solution using O(mn) space is probably a bad idea.
 *     A simple improvement uses O(m + n) space, but still not the best solution.
 *     Could you devise a constant space solution?
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/set-matrix-zeroes/">
 * Set Matrix Zeroes</a>
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;

        /*
        用一个数组标识哪一列需要置0。
        首先遍历矩阵的每一行，当遇到0时，将这一行置0，并设定标识数据相应Index元素；
        再遍历列，根据标识数组的值，进行列置0操纵。
         */
        int[] columnSetZeroFlag = new int[columnNum];
        for (int i = 0; i < rowNum; i++) {
            int[] currentRow = matrix[i];
            int index = 0;
            boolean setZero = false;
            while (index < currentRow.length) {
                if (currentRow[index] == 0) {
                    setZero = true;
                    columnSetZeroFlag[index] = 1;
                }
                index++;
            }
            if (setZero) {
                index = 0;
                while (index < currentRow.length) {
                    currentRow[index] = 0;
                    index++;
                }
            }
        }

        for (int j = 0; j < columnNum; j++) {
            int rowIndex = 0;

            if (columnSetZeroFlag[j] == 1) {
                rowIndex = 0;
                while (rowIndex < matrix.length) {
                    matrix[rowIndex][j] = 0;
                    rowIndex++;
                }
            }
        }
    }
}
