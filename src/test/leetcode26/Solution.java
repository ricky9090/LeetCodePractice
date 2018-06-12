package test.leetcode26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }

        int i = nums.length - 1;
        int result = nums.length;
        while (i > 0) {
            if (nums[i] == nums[i - 1]) {
                // shrink array 1 space
                for (int j = i - 1; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                result -= 1;
            }
            i--;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 2, 3, 4, 4, 5, 5, 5};
        //int[] test = {1, 1, 2};
        //int[] test = {1, 1};
        //int[] test = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6};
        Solution2 solution = new Solution2();
        int a = solution.removeDuplicates(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
        System.out.println("Length: " + a);
    }
}
