package study.leetcode.section150.no198;

/**
 * <h2>House Robber</h2>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money
 * of each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * <p>
 * <b>Example 1:</b><br>
 * Input: [1,2,3,1]<br>
 * Output: 4<br>
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).<br>
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * <b>Example 2:</b><br>
 * Input: [2,7,9,3,1]<br>
 * Output: 12<br>
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).<br>
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * @see <a href="https://leetcode.com/problems/house-robber/">
 * House Robber</a>
 */
public class Solution198 {
    public int rob(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(result[i - 1], result[i - 2] + nums[i]);
        }

        return Math.max(result[result.length - 2], result[result.length - 1]);

    }

    public static void main(String[] args) {
        int[] test = {2, 1, 1, 2};
        Solution198 solution = new Solution198();
        System.out.println(solution.rob(test));
    }
}
