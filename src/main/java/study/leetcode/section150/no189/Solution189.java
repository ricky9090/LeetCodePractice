package study.leetcode.section150.no189;

/**
 * <h2>Rotate Array</h2>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * </code></pre>
 * <b>Note:</b>
 * <ul>
 * <li>Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.</li>
 * <li>Could you do it in-place with O(1) extra space?</li>
 * </ul>
 *
 * @see <a href="https://leetcode-cn.com/problems/rotate-array/">
 * Rotate Array</a>
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int move = k % nums.length;
        int[] tmp = new int[move];
        for (int i = 0; i < move; i++) {
            tmp[i] = nums[nums.length - move + i];
        }

        for (int i = nums.length - move - 1; i >= 0; i--) {
            nums[i + move] = nums[i];
        }

        for (int i = 0; i < move; i++) {
            nums[i] = tmp[i];
        }

    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7};
        Solution189 solution189 = new Solution189();
        solution189.rotate(test, 3);
        System.out.println();
    }
}
