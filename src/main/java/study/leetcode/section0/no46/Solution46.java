package study.leetcode.section0.no46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h2>Permutations</h2>
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/permutations">Permutations</a>
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        List<Integer> gen = new ArrayList<>();
        List<Integer> remain = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            remain.add(nums[i]);
        }

        generate(gen, remain, nums.length, result);
        return result;
    }

    private void generate(final List<Integer> genList, final List<Integer> remain, int remainSize, List<List<Integer>> result) {
        if (remainSize == 0) {
            result.add(genList);
            return;
        }


        for (int i = 0; i < remainSize; i++) {
            List<Integer> nextRemain = new LinkedList<>(remain);
            List<Integer> nextGen = new ArrayList<>(genList);
            nextGen.add(nextRemain.get(i));
            nextRemain.remove(i);
            generate(nextGen, nextRemain, remainSize - 1, result);
        }
    }
}
