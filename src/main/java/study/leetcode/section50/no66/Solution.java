package study.leetcode.section50.no66;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * <b>Example 1:</b><br>
 * <p>
 * Input: [1,2,3]<br>
 * Output: [1,2,4]<br>
 * Explanation: The array represents the integer 123.<br>
 * <p>
 * <b>Example 2:</b><br>
 * <p>
 * Input: [4,3,2,1]<br>
 * Output: [4,3,2,2]<br>
 * Explanation: The array represents the integer 4321.
 *
 * @see <a href="https://leetcode-cn.com/problems/plus-one">
 * Plus One</a>
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int[] tmp = new int[digits.length + 1];
        int lastIndex = digits.length - 1;
        for (int i = lastIndex; i >= 0; i--) {
            if (i == lastIndex) {
                int addResult = digits[i] + 1;
                if (addResult >= 10) {
                    tmp[i + 1] = 0;
                    tmp[i] = 1;
                } else {
                    tmp[i + 1] = addResult;
                }
            } else {
                int addResult = tmp[i + 1] + digits[i];
                if (addResult >= 10) {
                    tmp[i + 1] = 0;
                    tmp[i] = 1;
                } else {
                    tmp[i + 1] = addResult;
                }
            }
        }

        if (tmp[0] == 0) {
            int[] result = new int[digits.length];
            for (int i = 1; i < tmp.length; i++) {
                result[i - 1] = tmp[i];
            }
            return result;
        }

        return tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {9, 9, 8};

        int[] result = solution.plusOne(test);
        for (int i : result) {
            System.out.print(i);
        }
    }
}
