package study.leetcode.section200.no217;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <h2>Contains Duplicate</h2>
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: [1,2,3,1]
 * Output: true
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: [1,2,3,4]
 * Output: false
 * </code></pre>
 * <b>Example 3:</b>
 * <pre><code>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/contains-duplicate">
 * Contains Duplicate</a>
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];
            Integer count = numCountMap.get(key);
            if (count == null || count <= 0) {
                numCountMap.put(key, 1);
            } else {
                numCountMap.put(key, count + 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = numCountMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }
}
