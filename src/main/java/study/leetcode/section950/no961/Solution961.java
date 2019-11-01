package study.leetcode.section950.no961;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <h2>N-Repeated Element in Size 2N Array</h2>
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * <p>
 * Return the element repeated N times.
 * <p>
 *
 *
 * <b>Example 1:</b>
 * <pre><code>
 * Input: [1,2,3,3]
 * Output: 3
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: [2,1,2,5,3,2]
 * Output: 2
 * </code></pre>
 * <b>Example 3:</b>
 * <pre><code>
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 * </code></pre>
 *
 *
 * <b>Note:</b>
 * <pre>
 *     4 <= A.length <= 10000
 *     0 <= A[i] < 10000
 *     A.length is even
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/">
 * N-Repeated Element in Size 2N Array</a>
 */
public class Solution961 {
    public int repeatedNTimes(int[] A) {
        int targetN = A.length / 2;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (countMap.get(A[i]) != null) {
                int n = countMap.get(A[i]);
                int m = n + 1;
                if (m == targetN) {
                    return A[i];
                }
                countMap.put(A[i], m);
            } else {
                countMap.put(A[i], 1);
            }
        }
        int result = 0;
        Set<Map.Entry<Integer, Integer>> countSet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : countSet) {
            if (entry.getValue() == targetN) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
