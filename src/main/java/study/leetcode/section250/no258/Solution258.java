package study.leetcode.section250.no258;


/**
 * Given a non-negative integer num, repeatedly add all its digits until the result
 * has only one digit.
 *
 * <p>Example:</p>
 * <p>Input: 38</p>
 * <p>Output: 2 </p>
 * <p>Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. </p>
 * <p>Since 2 has only one digit, return it.</p>
 *
 * @see <a href="https://leetcode.com/problems/add-digits/">
 * Add Digits</a>
 */
public class Solution258 {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int result = num;
        while (result >= 10) {
            int a = result % 10;
            result = (result / 10) + a;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution258 test = new Solution258();
        System.out.println(test.addDigits(38)); // 2
        System.out.println(test.addDigits(99)); // 9
        System.out.println(test.addDigits(252)); // 9
        System.out.println(test.addDigits(1024)); // 7
        System.out.println(test.addDigits(2048)); // 5
    }
}
