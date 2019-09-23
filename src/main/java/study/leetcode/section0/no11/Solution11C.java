package study.leetcode.section0.no11;

public class Solution11C {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex) {
            int actualHeight = Math.min(height[leftIndex], height[rightIndex]);
            int width = rightIndex - leftIndex;
            int actualArea = actualHeight * width;
            if (actualArea > maxArea) {
                maxArea = actualArea;
            }

            if (height[leftIndex] > height[rightIndex]) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return maxArea;
    }
}
