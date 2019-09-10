package study.leetcode.section0.no35;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 *
 * @see <a href="https://leetcode.com/problems/search-insert-position/description/">
 * Search Insert Position</a>
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int lowerIndex = 0;
        int upperIndex = nums.length - 1;
        int middleIndex = (nums.length - 1) / 2;

        while (lowerIndex < upperIndex) {
            if (target > nums[middleIndex]) {
                lowerIndex = middleIndex + 1;
            } else if (target < nums[middleIndex]) {
                upperIndex = middleIndex;
            } else {
                return middleIndex;
            }

            middleIndex = lowerIndex + ((upperIndex - lowerIndex) / 2);
        }
        if (nums[lowerIndex] < target) {
            return lowerIndex + 1;
        }
        return lowerIndex;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(test, 1));
        System.out.println(solution.searchInsert(test, 3));
        System.out.println(solution.searchInsert(test, 5));
        System.out.println(solution.searchInsert(test, 6));

        System.out.println(solution.searchInsert(test, 0));//0
        System.out.println(solution.searchInsert(test, 7));//4
        System.out.println(solution.searchInsert(test, 2));//1
        System.out.println(solution.searchInsert(test, 4));//2

    }
}
