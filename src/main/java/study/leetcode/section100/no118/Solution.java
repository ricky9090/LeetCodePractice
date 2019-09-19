package study.leetcode.section100.no118;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Pascal's Triangle</h2>
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * <b>Example:</b>
 * <p>
 * Input: 5<br>
 * Output:<br>
 * <pre>
 * [
 *       [1],
 *      [1,1],
 *     [1,2,1],
 *    [1,3,3,1],
 *   [1,4,6,4,1]
 *  ]
 *
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/pascals-triangle">
 * Pascal's Triangle</a>
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        generateSubList(numRows, 0, result);
        return result;
    }

    private void generateSubList(int numRows, int currentLoop, List<List<Integer>> result) {
        if (currentLoop >= numRows) {
            return;
        }
        List<Integer> currentList = new ArrayList<>();
        List<Integer> lastList;
        if (result.size() == 0) {
            lastList = new ArrayList<>();
        } else {
            lastList = result.get(result.size() - 1);
        }
        int listSize = lastList.size() + 1;
        for (int i = 0; i < listSize; i++) {
            if (i == 0 || i == listSize - 1) {
                currentList.add(1);
            } else {
                currentList.add(lastList.get(i - 1) + lastList.get(i));
            }
        }
        result.add(currentList);
        int nextLoop = currentLoop + 1;
        generateSubList(numRows, nextLoop, result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.generate(5);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
