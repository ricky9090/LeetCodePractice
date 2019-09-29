package study.leetcode.section150.no191;

/**
 * <h2>Number of 1 Bits</h2>
 * Write a function that takes an unsigned integer and return
 * the number of '1' bits it has (also known as the Hamming weight).
 *
 * @see <a href="https://leetcode.com/problems/number-of-1-bits/">
 * Number of 1 Bits</a>
 */
public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int target = n;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = target & 1;
            if (tmp == 1) {
                count++;
            }
            target = target >>> 1;
        }
        return count;
    }
}
