package study.leetcode.section700.no704;

/**
 * <h2>Binary Search</h2>
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * </code></pre>
 * <b>Note:</b>
 * <ul>
 * <li>You may assume that all elements in nums are unique.</li>
 * <li>n will be in the range [1, 10000].</li>
 * <li>The value of each element in nums will be in the range [-9999, 9999].</li>
 * </ul>
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-search/">
 * Binary Search</a>
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        int result = -1;
        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {-1, 0, 3, 5, 9};
        Solution704 solution704 = new Solution704();
        System.out.println(solution704.search(test, 9));
    }
}
