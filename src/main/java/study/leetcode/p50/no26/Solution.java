package study.leetcode.p50.no26;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element
 * appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the
 * input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being
 * modified to 0, 1, 2, 3, and 4 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 *
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/">
 * Remove Duplicates from Sorted Array - LeetCode</a>
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }

        int i = nums.length - 1;
        int result = nums.length;
        while (i > 0) {
            if (nums[i] == nums[i - 1]) {
                // shrink array 1 space
                for (int j = i - 1; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                result -= 1;
            }
            i--;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 2, 3, 4, 4, 5, 5, 5};
        //int[] test = {1, 1, 2};
        //int[] test = {1, 1};
        //int[] test = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6};
        Solution2 solution = new Solution2();
        int a = solution.removeDuplicates(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
        System.out.println("Length: " + a);
    }
}
