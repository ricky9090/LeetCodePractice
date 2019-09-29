package study.leetcode.section350.no371;

public class Solution371 {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum, carry;
        sum = a ^ b;
        carry = (a & b) << 1;
        System.out.println("sum: " + sum + ", carry: " + carry);
        return getSum(sum, carry);
    }

    public static void main(String[] args) {
        Solution371 test = new Solution371();

        System.out.println(test.getSum(3, 5));
    }
}
