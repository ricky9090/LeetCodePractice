package study.leetcode.section250.no283;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * <p>Example:</p>
 * <p>Input: [0,1,0,3,12]</p>
 * <p>Output: [1,3,12,0,0]</p>
 * <p>Note:</p>
 * <p>You must do this in-place without making a copy of the array.</p>
 * <p>Minimize the total number of operations.</p>
 *
 * @see <a href="https://leetcode.com/problems/move-zeroes/description/">
 * Move Zeroes - LeetCode</a>
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int zeroIndex = 0;
        int currentIndex = 0;

        // 非零元素放到数组前面，后面的元素置零
        while (currentIndex < n) {
            if (nums[currentIndex] != 0) {
                nums[zeroIndex] = nums[currentIndex];
                zeroIndex++;
            }
            currentIndex++;
        }

        while (zeroIndex < n) {
            nums[zeroIndex] = 0;
            zeroIndex++;
        }

    }

    public static void main(String[] args) {
        int test[] = {0, 1, 0, 3, 12};
        Solution283 solution = new Solution283();
        solution.moveZeroes(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + ", ");
        }
    }
}
