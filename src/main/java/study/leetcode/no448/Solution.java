package study.leetcode.no448;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume
 * the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 *
 * @see <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/">
 * Find All Numbers Disappeared in an Array - LeetCode</a>
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        int count[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        LinkedList<Integer> result = new LinkedList<>();
        for (int j = 1; j < count.length; j++) {
            if (count[j] == 0) {
                result.add(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution solution = new Solution();
        List<Integer> result = solution.findDisappearedNumbers(test);
        for (Integer num : result) {
            System.out.print(num + ", ");
        }
    }
}
