package study.leetcode.section50.no88;

/**
 * <h2>Merge Sorted Array</h2>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>The number of elements initialized in nums1 and nums2 are m and n respectively.</li>
 * <li>You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.</li>
 * </ul>
 * <b>Example:</b>
 * <pre><code>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/merge-sorted-array">
 * Merge Sorted Array</a>
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        final int length1 = m;
        final int length2 = n;

        int index1 = 0;
        int index2 = 0;
        int tmpIndex = 0;
        int[] tmp = new int[length1 + length2];
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] <= nums2[index2]) {
                tmp[tmpIndex] = nums1[index1];
                index1++;
            } else {
                tmp[tmpIndex] = nums2[index2];
                index2++;
            }
            tmpIndex++;
        }

        while (index1 < length1) {
            tmp[tmpIndex] = nums1[index1];
            tmpIndex++;
            index1++;
        }

        while (index2 < length2) {
            tmp[tmpIndex] = nums2[index2];
            tmpIndex++;
            index2++;
        }

        for (int i = 0; i < length1 + length2; i++) {
            nums1[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 0, 0, 0};
        int[] test2 = {2, 5, 6};
        Solution88 solution = new Solution88();
        solution.merge(test1, 3, test2, 3);
        System.out.println(test1);  // for debug breakpoint
    }
}
