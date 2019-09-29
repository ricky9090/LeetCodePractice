package study.leetcode.section300.no303;


/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * <p>Example:<br>
 * Given nums = [-2, 0, 3, -5, 2, -1]</p>
 *
 * <p>
 * sumRange(0, 2) -> 1<br>
 * sumRange(2, 5) -> -1<br>
 * sumRange(0, 5) -> -3
 * </p>
 *
 * <p>Note:<br>
 * You may assume that the array does not change.<br>
 * There are many calls to sumRange function.</p>
 *
 * @see <a href="https://leetcode.com/problems/range-sum-query-immutable/">
 * Range Sum Query - Immutable</a>
 */
public class NumArray303 {

    int[] sumArray;

    public NumArray303(int[] nums) {

        if (nums != null) {
            sumArray = new int[nums.length + 1];
            for (int i = 0; i < sumArray.length; i++) {
                if (i == 0) {
                    sumArray[i] = 0;
                } else {
                    sumArray[i] = nums[i - 1] + sumArray[i - 1];
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        return sumArray[j + 1] - sumArray[i];
    }

    public static void main(String[] args) {
        int[] array = {-2, 0, 3, -5, 2, -1};
        NumArray303 test = new NumArray303(array);
        System.out.println(test.sumRange(0, 2));
        System.out.println(test.sumRange(2, 5));
        System.out.println(test.sumRange(0, 5));
    }
}
