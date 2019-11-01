package study.leetcode.section850.no867;

/**
 * <h2>Transpose Matrix</h2>
 * Given a matrix A, return the transpose of A.
 * <p>
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 * </code></pre>
 * <b>Note:</b>
 * <pre>
 *     1 <= A.length <= 1000
 *     1 <= A[0].length <= 1000
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/transpose-matrix/">
 * Transpose Matrix</a>
 */
public class Solution867 {
    public int[][] transpose(int[][] A) {
        if (A == null) {
            return null;
        }
        if (A.length == 0) {
            return new int[0][0];
        }

        int transposeLength = A.length;
        int width = A[0].length;

        int[][] result = new int[width][transposeLength];
        for (int i = 0; i < width; i++) {
            int[] transposeRow = new int[transposeLength];
            for (int j = 0; j < transposeLength; j++) {
                transposeRow[j] = A[j][i];
            }
            result[i] = transposeRow;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution867 solution867 = new Solution867();
        int[][] result = solution867.transpose(test);
        System.out.println();
    }
}
