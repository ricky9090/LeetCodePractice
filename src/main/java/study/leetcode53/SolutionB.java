package study.leetcode53;

public class SolutionB {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int sum = nums[0];
        // 只遍历一次，并记录最大值
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int currentSum = sum + tmp;
            // 如果之前的和小于零，则从最新的元素重新记录
            sum = currentSum > tmp ?  currentSum : tmp;
            // 只保存最大值，把其它求和丢掉
            max = max > sum ? max : sum;
        }
        return max;
    }
}
