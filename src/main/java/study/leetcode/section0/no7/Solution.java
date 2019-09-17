package study.leetcode.section0.no7;

public class Solution {
    public int reverse(int x) {

        if (x == 0) {
            return 0;
        }
        long result = 0;
        while(x != 0) {
            int lastNum = x % 10;
            x = x /10;
            result = result * 10 + lastNum;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483412));
    }
}
