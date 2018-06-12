package test.leetcode26;

public class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }

        int size = 1;
        for (int n = 0; n < nums.length - 1; n++) {
            if (nums[n] == nums[n + 1]) {
                continue;
            }
            // detect change: n+1 is bigger. 
            // size+=1, replace "actual" last element
            size++;
            nums[size - 1] = nums[n + 1];
        }
        return size;
    }
}
