package study.leetcode26;

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
public class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }

        int size = 1;
        for (int n = 0; n < nums.length - 1; n++) {
            if (nums[n] == nums[n + 1]) {
                continue;
            }
            // detect change: n+1 is bigger. 
            // size+=1, replace "actual" last element
            size++;
            nums[size - 1] = nums[n + 1];
        }
        return size;
    }
}
