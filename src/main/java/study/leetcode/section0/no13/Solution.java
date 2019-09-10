package study.leetcode.section0.no13;

/**
 * <p>
 * Roman numerals are represented by seven different symbols: <b>I, V, X, L, C, D and M</b>.
 * </p>
 * <table>
 * <tr> <td>Symbol</td><td>Value</td> </tr>
 * <tr> <td>I</td><td>1</td> </tr>
 * <tr> <td>V</td><td>5</td> </tr>
 * <tr> <td>X</td><td>10</td> </tr>
 * <tr> <td>L</td><td>50</td> </tr>
 * <tr> <td>C</td><td>100</td> </tr>
 * <tr> <td>D</td><td>500</td> </tr>
 * <tr> <td>M</td><td>1000</td> </tr>
 * </table>
 * <p>For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written
 * as XXVII, which is XX + V + II.</p>
 *
 * <p>Roman numerals are usually written largest to smallest from left to right. However,
 * the numeral for four is not IIII. Instead, the number four is written as IV. Because the
 * one is before the five we subtract it making four. The same principle applies to the number
 * nine, which is written as IX. There are six instances where subtraction is used:</p>
 *
 * <ul>
 * <li>I can be placed before V (5) and X (10) to make 4 and 9.</li>
 * <li>X can be placed before L (50) and C (100) to make 40 and 90.</li>
 * <li>C can be placed before D (500) and M (1000) to make 400 and 900.</li>
 * </ul>
 *
 * <p>Given a roman numeral, convert it to an integer. Input is guaranteed to be within the
 * range from 1 to 3999.</p>
 *
 * @see <a href="https://leetcode.com/problems/roman-to-integer/">
 * Roman to Integer - LeetCode</a>
 * @see <a href="https://leetcode-cn.com/problems/roman-to-integer/">
 * 罗马数字转整数 - LeetCode-cn</a>
 */
class Solution {
    public int romanToInt(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        int result = 0;  // 最后结果
        int len = s.length();
        char[] array = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char current = array[i];
            switch (current) {  // I,X,C字符中的特殊逻辑也可以移到switch外统一处理
                case 'I':
                    if ((i + 1) < len) {
                        char next = array[i + 1];
                        if (next == 'V') {
                            result += 4;
                            i++;
                            break;
                        }
                        if (next == 'X') {
                            result += 9;
                            i++;
                            break;
                        }
                    }
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if ((i + 1) < len) {
                        char next = array[i + 1];
                        if (next == 'L') {
                            result += 40;
                            i++;
                            break;
                        }
                        if (next == 'C') {
                            result += 90;
                            i++;
                            break;
                        }
                    }
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if ((i + 1) < len) {
                        char next = array[i + 1];
                        if (next == 'D') {
                            result += 400;
                            i++;
                            break;
                        }
                        if (next == 'M') {
                            result += 900;
                            i++;
                            break;
                        }
                    }
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}
