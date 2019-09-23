package study.leetcode.section0.no11;

public class Solution11B {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int width = height.length - 1; width > 0; width--) {
            for (int startIndex = 0; startIndex + width < height.length; startIndex++) {
                int actualHeight = Math.min(height[startIndex], height[startIndex + width]);
                int capacityArea = actualHeight * width;
                if (capacityArea > maxArea) {
                    maxArea = capacityArea;
                }
            }
        }

        return maxArea;
    }
}
