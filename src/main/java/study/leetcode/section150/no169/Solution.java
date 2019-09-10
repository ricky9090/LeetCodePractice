package study.leetcode.section150.no169;

import java.util.HashMap;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * @see <a href="https://leetcode.com/problems/majority-element/description/">
 * Majority Element - LeetCode</a>
 */
public class Solution {
    // TODO better solution
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> data = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (data.get(nums[i]) == null) {
                data.put(nums[i], 1);
            } else {
                int n = data.get(nums[i]) + 1;
                data.put(nums[i], n);
            }
        }

        int result = nums[0];
        for (Integer n : data.keySet()) {
            if (data.get(result) < data.get(n)) {
                result = n;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int test[] = {3, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(test));
    }
}
