package study.leetcode.section300.no347;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * <h2>Top K Frequent Elements</h2>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: nums = [1], k = 1
 * Output: [1]
 * </code></pre>
 * <b>Note:</b>
 * <ul>
 * <li>You may assume k is always valid, 1 ≤ k ≤ number of unique elements.</li>
 * <li>Your algorithm's time complexity must be better than O(n log n), where n is the array's size.</li>
 * </ul>
 *
 * @see <a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">
 * Top K Frequent Elements</a>
 */
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int n = nums.length;

        LinkedList<Integer> topList = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], (map.get(nums[i]) + 1));
            } else {
                map.put(nums[i], 1);
            }

        }

        Object[] result = map.keySet().toArray();
        for (int a = 0; a < k; a++) {
            for (int b = 0; b < result.length - 1 - a; b++) {

                if (map.get(result[b]) > map.get(result[b + 1])) {
                    int temp = (int) result[b + 1];
                    result[b + 1] = result[b];
                    result[b] = temp;
                }
            }
        }


        for (int m = 0; m < k; m++) {
            topList.add((int) result[result.length - 1 - m]);
            System.out.println("add: " + result[result.length - 1 - m]);
        }

        return topList;
    }
}
