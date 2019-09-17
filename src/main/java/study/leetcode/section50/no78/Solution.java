package study.leetcode.section50.no78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        int loopMax = nums.length;
        generate(nums, loopMax, 0, new ArrayList<>(), result);
        result.add(new ArrayList<>());
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
        Solution solution = new Solution();
        int[] test = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(test);
        System.out.println(result);
    }
}
