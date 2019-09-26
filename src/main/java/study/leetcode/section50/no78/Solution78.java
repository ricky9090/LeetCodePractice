package study.leetcode.section50.no78;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Subsets</h2>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/subsets">
 * Subsets</a>
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        int loopMax = nums.length;
        generate(nums, loopMax, 0, new ArrayList<Integer>(), result);
        result.add(new ArrayList<Integer>());
        return result;
    }

    private void generate(int[] numsArray, int loopMax, int currentLoop, List<Integer> generateList, List<List<Integer>> resultList) {
        if (currentLoop >= loopMax) {
            return;
        }
        List<Integer> tmpA = new ArrayList<>();  // pass item
        tmpA.addAll(generateList);

        List<Integer> tmpB = new ArrayList<>();  // add item
        tmpB.addAll(generateList);
        tmpB.add(numsArray[currentLoop]);

        resultList.add(tmpB);

        int next = ++currentLoop;
        generate(numsArray, loopMax, next, tmpA, resultList);
        generate(numsArray, loopMax, next, tmpB, resultList);

    }

    public static void main(String[] args) {
        Solution78 solution = new Solution78();
        int[] test = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(test);
        System.out.println(result);
    }
}
