package study.leetcode.p50.no9;

/**
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/palindrome-number/">
 * Palindrome Number - LeetCode</a>
 * @see <a href="https://leetcode-cn.com/problems/palindrome-number/">
 * 回文数 - LeetCode-cn</a>
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        int tmp = x;
        int result = 0;
        while (tmp != 0) {
            int a = tmp % 10;
            tmp = tmp / 10;
            result = result * 10 + a;
        }

        if (result == x) {
            return true;
        }
        return false;
    }
}
