package study.leetcode.section100.no137;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <h2>Single Number II</h2>
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * <b>Note:</b>
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: [2,2,3,2]
 * Output: 3
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/single-number-ii">
 * Single Number II</a>
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            if (countMap.get(n) == null) {
                countMap.put(n, 1);
            } else {
                int count = countMap.get(n);
                countMap.put(n, count + 1);
            }
        }

        int result = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> item : entrySet) {
            if (item.getValue() == 1) {
                result = item.getKey();
            }
        }
        return result;
    }
}
