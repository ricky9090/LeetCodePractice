package study.leetcode.section0.no11;

/**
 * <h2>Container With Most Water</h2>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line
 * i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * <img width="280" height="210" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" alt="">
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. <br>
 * In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water">
 * Container With Most Water</a>
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int outerIndex = 0; outerIndex < height.length; outerIndex++) {
            for (int innerIndex = height.length - 1; innerIndex > outerIndex; innerIndex--) {
                int actualHeight = Math.min(height[outerIndex], height[innerIndex]);
                int width = innerIndex - outerIndex;
                int capacityArea = actualHeight * width;
                if (capacityArea > maxArea) {
                    maxArea = capacityArea;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution11 solution = new Solution11();
        System.out.println(solution.maxArea(test));
    }
}
