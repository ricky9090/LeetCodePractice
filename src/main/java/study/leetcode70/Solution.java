package study.leetcode70;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 *
 * @see <a href="https://leetcode.com/problems/climbing-stairs/description/">
 * Climbing Stairs</a>
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int total = 0;
        int total_p = 2; // prev init climb to 2
        int total_pp = 1; // prev prev init climb to 1
        for (int i = 3; i <= n; i++) {
            total = total_p + total_pp;
            total_pp = total_p;
            total_p = total;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(0));
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
        System.out.println(solution.climbStairs(6));
    }
}
