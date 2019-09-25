package study.leetcode.section0.no47;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <h2>Permutations II</h2>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/permutations-ii">
 * Permutations II</a>
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        List<Integer> gen = new ArrayList<>();
        List<Integer> remain = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            remain.add(nums[i]);
        }
        Collections.sort(remain);

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
            if (i > 0 && (nextRemain.get(i - 1).equals(nextRemain.get(i)))) {
                continue;
            }
            nextGen.add(nextRemain.get(i));
            nextRemain.remove(i);
            generate(nextGen, nextRemain, remainSize - 1, result);

        }
    }
}
