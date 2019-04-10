package study.leetcode.p50.no6;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
 * like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * <code>
 * P&nbsp;&nbsp;&nbsp;A&nbsp;&nbsp;&nbsp;H&nbsp;&nbsp;&nbsp;N<br>
 * A&nbsp;P&nbsp;L&nbsp;S&nbsp;I&nbsp;I&nbsp;G<br>
 * Y&nbsp;&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;R<br>
 * </code>
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/description/">
 * ZigZag Conversion - LeetCode</a>
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[][] board = new char[numRows][s.length()];

        int n = 0;
        int rowIndex = 0, colIndex = 0;
        int state = 0;
        while (n < s.length()) {
            if (rowIndex == numRows) {
                rowIndex = numRows - 2;
                colIndex++;
            }
            if (rowIndex == -1) {
                rowIndex = 1;
            }
            board[rowIndex][colIndex] = s.charAt(n);
            if (state == 0) {
                rowIndex++;
            } else {
                rowIndex--;
                colIndex++;
            }
            if (rowIndex == numRows) {
                state = 1;
            }
            if (rowIndex == -1) {
                state = 0;
            }

            n++;
        }

        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (board[i][j] != 0) {
                    sBuffer.append(board[i][j]);
                }
            }
        }
        return sBuffer.toString();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }
}
