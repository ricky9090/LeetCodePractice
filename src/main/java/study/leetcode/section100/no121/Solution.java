package study.leetcode.section100.no121;

/**
 * Say you have an array for which the i^th element is the price of
 * a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm
 * to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * <b>Example 1:</b><br>
 * <p>
 * Input: [7,1,5,3,6,4]<br>
 * Output: 5<br>
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * <p>
 * <b>Example 2:</b><br>
 * <p>
 * Input: [7,6,4,3,1]<br>
 * Output: 0<br>
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.<br>
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">
 * Best Time to Buy and Sell Stock</a>
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int[] lowest = new int[prices.length];
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                lowest[i] = prices[i];
            } else {
                lowest[i] = Math.min(prices[i], lowest[i - 1]);
            }

            result = Math.max(result, prices[i] - lowest[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(test));

        int[] test2 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(test2));
    }
}
