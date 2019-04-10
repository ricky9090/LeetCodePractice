package study.leetcode.p50.no4;

/**
 * There are two sorted arrays <strong>nums1</strong> and <strong>nums2</strong>
 * of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/description/">
 * Median of Two Sorted Arrays - LeetCode</a>
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 当数组为空时，直接返回非空数组的中间值
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[(n - 1) / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[(m - 1) / 2];
            }
        }

        // 两个数组为有序数组，使用归并排序中的合并步骤，得到完整的有序数组。
        int temp1 = 0, temp2 = 0;
        int[] total = new int[m + n];
        int index = 0;
        while (temp1 < m && temp2 < n) {
            if (nums1[temp1] < nums2[temp2]) {
                total[index++] = nums1[temp1++];
            } else {
                total[index++] = nums2[temp2++];
            }
        }

        while (temp1 < m) {
            total[index++] = nums1[temp1++];
        }

        while (temp2 < n) {
            total[index++] = nums2[temp2++];
        }

        // 返回有序数组中的中间值
        if ((m + n) % 2 == 0) {
            return (double) (total[(m + n) / 2 - 1] + total[(m + n) / 2]) / 2.0;
        } else {
            return total[(m + n - 1) / 2];
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] a = {1, 2};
        int[] b = {3, 4};
        // double timeA = System.currentTimeMillis();
        System.out.println(test.findMedianSortedArrays(a, b));
        // double timeB = System.currentTimeMillis();
        // double time = timeB - timeA;
        // System.out.println(time);
    }
}
