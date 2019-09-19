package study.leetcode.section50.no67;

import java.util.Arrays;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * <b>Example 1:</b>
 * <p>
 * Input: a = "11", b = "1"<br>
 * Output: "100"
 * <p>
 * <b>Example 2:</b>
 * <p>
 * Input: a = "1010", b = "1011"<br>
 * Output: "10101"
 *
 * @see <a href="https://leetcode-cn.com/problems/add-binary">
 * Add Binary</a>
 */
public class Solution {
    public String addBinary(String a, String b) {
        String result;

        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        int length;
        if (arrayA.length >= arrayB.length) {
            length = arrayA.length + 1;
        } else {
            length = arrayB.length + 1;
        }

        char[] charResult = new char[length];
        int arrayAIndex = arrayA.length - 1;
        int arrayBIndex = arrayB.length - 1;
        int carry = 0;
        for (int i = length - 1; i > 0; i--) {
            char tmpA;
            char tmpB;
            if (arrayAIndex >= 0) {
                tmpA = arrayA[arrayAIndex];
            } else {
                tmpA = '0';
            }
            if (arrayBIndex >= 0) {
                tmpB = arrayB[arrayBIndex];
            } else {
                tmpB = '0';
            }

            int tmpAInt = 0;
            if (tmpA == '1') {
                tmpAInt = 1;
            }
            int tmpBInt = 0;
            if (tmpB == '1') {
                tmpBInt = 1;
            }
            int tmpC = tmpAInt + tmpBInt + carry;

            if (tmpC == 3) {
                carry = 1;
                charResult[i] = '1';
            } else if (tmpC == 2) {
                carry = 1;
                charResult[i] = '0';
            } else if (tmpC == 1) {
                carry = 0;
                charResult[i] = '1';
            } else {
                carry = 0;
                charResult[i] = '0';
            }

            arrayAIndex--;
            arrayBIndex--;
        }

        if (carry == 1) {
            charResult[0] = '1';
        }

        if (charResult[0] != '1') {
            char[] charResult2 =
                    Arrays.copyOfRange(charResult, 1, charResult.length);
            return new String(charResult2);
        }

        result = new String(charResult);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("10", "11"));
    }
}
