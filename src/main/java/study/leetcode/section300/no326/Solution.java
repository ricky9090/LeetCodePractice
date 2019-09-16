package study.leetcode.section300.no326;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Example 1:<br>
 * Input: 27<br>
 * Output: true
 * <p>
 * Example 2:<br>
 * Input: 0<br>
 * Output: false
 * <p>
 * Example 3:<br>
 * Input: 9<br>
 * Output: true
 * <p>
 * Example 4:<br>
 * Input: 45<br>
 * Output: false
 *
 * @see <a href="https://leetcode.com/problems/power-of-three/">
 * Power of Three</a>
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }

        int lastNum = n % 10;
        if (lastNum == 0 || lastNum == 2 || lastNum == 4 ||
                lastNum == 5 || lastNum == 6 || lastNum == 8) {
            return false;
        }

        int tmp = n;
        while (tmp != 1) {
            if (tmp % 3 != 0) {
                return false;
            }
            tmp = tmp / 3;
        }
        return true;

    }

    public static void main(String[] args) {
        Solution test = new Solution();
        for (int i = 0; i < 30; i++) {
            System.out.println(i + ":, " + test.isPowerOfThree(i));
        }
    }
}
