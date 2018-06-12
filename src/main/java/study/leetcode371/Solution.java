package study.leetcode371;

public class Solution {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum, carry;
        sum = a^b;
        carry = (a&b) << 1;
        System.out.println("sum: " + sum + ", carry: " + carry);
        return getSum(sum, carry);
    }
    
    public static void main(String[] args) {
    	Solution test = new Solution();
    	
    	System.out.println(test.getSum(3, 5));
    }
}
