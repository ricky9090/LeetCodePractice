package study.leetcode.section0.no36;

import java.util.*;

/**
 * <h2>Valid Sudoku</h2>
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <ol>
 * <li>Each row must contain the digits 1-9 without repetition.</li>
 * <li>Each column must contain the digits 1-9 without repetition.</li>
 * <li>Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.</li>
 * </ol>
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * </code></pre>
 *
 * <b>Note:</b>
 * <ul>
 * <li>A Sudoku board (partially filled) could be valid but is not necessarily solvable.</li>
 * <li>Only the filled cells need to be validated according to the mentioned rules.</li>
 * <li>The given board contain only digits 1-9 and the character '.'.</li>
 * <li>The given board size is always 9x9.</li>
 * </ul>
 *
 * @see <a href="https://leetcode-cn.com/problems/valid-sudoku">
 * Valid Sudoku</a>
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        List<HashMap<String, Integer>> rowMapList = new ArrayList<>(9);
        List<HashMap<String, Integer>> columnMapList = new ArrayList<>(9);
        List<HashMap<String, Integer>> blockMapList = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            rowMapList.add(new HashMap<String, Integer>());
        }
        for (int i = 0; i < 9; i++) {
            columnMapList.add(new HashMap<String, Integer>());
        }
        for (int i = 0; i < 9; i++) {
            blockMapList.add(new HashMap<String, Integer>());
        }

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                char c = board[y][x];
                String key = String.valueOf(c);
                if (c == '.') {
                    continue;
                }
                // put row
                if (rowMapList.get(y).get(key) == null) {
                    rowMapList.get(y).put(key, 1);
                } else {
                    int n = rowMapList.get(y).get(key);
                    rowMapList.get(y).put(key, n + 1);
                }
                // put column
                if (columnMapList.get(x).get(key) == null) {
                    columnMapList.get(x).put(key, 1);
                } else {
                    int n = columnMapList.get(x).get(key);
                    columnMapList.get(x).put(key, n + 1);
                }
                // put block
                int blockIndex = getBlockIndex(x, y);
                if (blockMapList.get(blockIndex).get(key) == null) {
                    blockMapList.get(blockIndex).put(key, 1);
                } else {
                    int n = blockMapList.get(blockIndex).get(key);
                    blockMapList.get(blockIndex).put(key, n + 1);
                }
            }
        }

        for (HashMap<String, Integer> map : rowMapList) {
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            for (Map.Entry<String, Integer> entry : set) {
                if (entry.getValue() > 1) {
                    return false;
                }
            }
        }

        for (HashMap<String, Integer> map : columnMapList) {
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            for (Map.Entry<String, Integer> entry : set) {
                if (entry.getValue() > 1) {
                    return false;
                }
            }
        }

        for (HashMap<String, Integer> map : blockMapList) {
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            for (Map.Entry<String, Integer> entry : set) {
                if (entry.getValue() > 1) {
                    return false;
                }
            }
        }
        return true;

    }

    private int getBlockIndex(int x, int y) {
        if (x < 3) {
            if (y < 3) {
                return 0;
            } else if (y < 6) {
                return 1;
            } else {
                return 2;
            }
        } else if (x < 6) {
            if (y < 3) {
                return 3;
            } else if (y < 6) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if (y < 3) {
                return 6;
            } else if (y < 6) {
                return 7;
            } else {
                return 8;
            }
        }
    }
}
