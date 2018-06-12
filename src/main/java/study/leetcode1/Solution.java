package study.leetcode1;

import java.util.HashMap;

/**
 * Given an array of integers, return <strong>indices</strong> of the two numbers
 * such that they add up to a specific target.
 * <p>
 * You may assume that each input would have <strong>exactly</strong> one solution,
 * and you may not use the same element twice.
 *
 * @see <a href="https://leetcode.com/problems/two-sum/description/">Two Sum - Leetcode</a>
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        // <num, index>
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }

        for (int n = 0; n < length; n++) {
            int a = nums[n];
            int b = target - a;
            if ((map.get(b) != null) && (map.get(b) != n)) {
                int[] result = {n, map.get(b)};
                return result;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 5, 11};
        Solution test = new Solution();
        int[] result = test.twoSum(a, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
