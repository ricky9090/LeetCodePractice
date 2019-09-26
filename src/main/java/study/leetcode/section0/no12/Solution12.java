package study.leetcode.section0.no12;

/**
 * <h2>Integer to Roman</h2>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * <pre><code>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * </code></pre>
 * <p>
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <ul>
 * <li>I can be placed before V (5) and X (10) to make 4 and 9.</li>
 * <li>X can be placed before L (50) and C (100) to make 40 and 90.</li>
 * <li>C can be placed before D (500) and M (1000) to make 400 and 900.</li>
 * </ul>
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * <b>Example 1:</b><br>
 * <pre>
 * Input: 3
 * Output: "III"
 * </pre>
 * <b>Example 2:</b><br>
 * <pre>
 * Input: 4
 * Output: "IV"
 * </pre>
 * <b>Example 3:</b><br>
 * <pre>
 * Input: 9
 * Output: "IX"
 * </pre>
 * <b>Example 4:</b><br>
 * <pre>
 * Input: 58
 * Output: "LVIII"
 * </pre>
 * Explanation: L = 50, V = 5, III = 3.<br><br>
 *
 * <b>Example 5:</b><br>
 * <pre>
 * Input: 1994
 * Output: "MCMXCIV"
 * </pre>
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.<br><br>
 *
 * @see <a href="https://leetcode-cn.com/problems/integer-to-roman">
 * Integer to Roman</a>
 */
public class Solution12 {
    public String intToRoman(int num) {
        String[] arrayA = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] arrayB = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] arrayC = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] arrayD = {"M", "MM", "MMM"};

        String result = "";
        int tmp = num;
        int a = tmp % 10;
        tmp = tmp / 10;
        if (a > 0) {
            result = arrayA[a - 1] + result;
        }

        int b = tmp % 10;
        tmp = tmp / 10;
        if (b > 0) {
            result = arrayB[b - 1] + result;
        }

        int c = tmp % 10;
        tmp = tmp / 10;
        if (c > 0) {
            result = arrayC[c - 1] + result;
        }

        int d = tmp % 10;
        tmp = tmp / 10;
        if (d > 0) {
            result = arrayD[d - 1] + result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution12 solution = new Solution12();
        System.out.println(solution.intToRoman(1));
        System.out.println(solution.intToRoman(6));
        System.out.println(solution.intToRoman(19));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman(3999));
    }
}
