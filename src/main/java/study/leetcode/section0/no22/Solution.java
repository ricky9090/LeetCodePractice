package study.leetcode.section0.no22;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [<br>
 * "((()))",<br>
 * "(()())",<br>
 * "(())()",<br>
 * "()(())",<br>
 * "()()()"<br>
 * ]
 *
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">
 * Generate Parentheses</a>
 */
public class Solution {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> result = new ArrayList<>();
        int allCount = (int) Math.pow(2, 2 * n);
        for (int i = 0; i <= allCount; i++) {
            checkIndex(2 * n, i, result);
        }

        return result;
    }

    private void checkIndex(int loopCount, int index, List<String> resultList) {
        if (index == 0) {
            return;
        }
        int tmp = index;
        int balance = 0;
        int maxBalance = loopCount / 2;
        boolean valid = false;
        String resultStr = "";
        for (int i = 0; i < loopCount; i++) {
            int flag = tmp % 2;
            tmp = tmp >>> 1;

            if (balance == 0 && flag == LEFT) {
                balance = -1;
                break;
            }
            if (flag == RIGHT) {
                balance++;
                resultStr = ")" + resultStr;
                if (balance > maxBalance) {
                    break;
                }
            } else if (flag == LEFT) {
                balance--;
                resultStr = "(" + resultStr;
            }
        }
        if (balance == 0) {
            resultList.add(resultStr);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
