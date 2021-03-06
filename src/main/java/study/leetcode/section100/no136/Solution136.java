package study.leetcode.section100.no136;

import java.util.HashMap;

public class Solution136 {
    
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], nums[i]);
            }
            
        }
        for (int i = 0; i < length; i ++) {
            if (map.containsKey(nums[i])) {
                result = nums[i];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 1, 2, 2, 3, 4, 3};
        Solution136 test = new Solution136();
        System.out.println(test.singleNumber(nums));
    }

}
