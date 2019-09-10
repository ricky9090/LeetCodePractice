package study.leetcode.section50.no53;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * @see <a href="https://leetcode.com/problems/maximum-subarray/description/">
 * Maximum Subarray - LeetCode</a>
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int lower = 0;
        int higher = nums.length - 1;
        int sum = 0;
        int result = 0;
        // 展开所有可能的和，记录最大值
        for (lower = 0; lower < nums.length; lower++) {
            for (higher = 0; higher < nums.length; higher++) {
                if (lower > higher) {
                    continue;
                }
                if (lower < higher) {
                    sum = sum + nums[higher];
                } else if (lower == higher) {
                    sum = nums[higher];
                }
                if ((lower == 0 && higher == 0) || sum > result) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] test = {-1,-2};
        //int[] test = {-1, -1, -2, -2};
        //int[] test = {8, -1, -1, 3};
        int[] test = {8, -19, 5, -4, 20};
        //int[] test = {-3, -2};
        System.out.println(solution.maxSubArray(test));
    }
}
