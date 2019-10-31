package study.leetcode.section100.no122;

/**
 * <h2>Best Time to Buy and Sell Stock II</h2>
 * Say you have an array for which the <em>i</em><sup>th</sup> element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * </code></pre>
 * <b>Example 3:</b>
 * <pre><code>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">
 * Best Time to Buy and Sell Stock II</a>
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] maxValue = new int[prices.length];
        maxValue[0] = 0;
        int sum = 0;
        for (int i = 1; i < maxValue.length; i++) {
            int value = 0 - prices[i - 1] + prices[i];
            maxValue[i] = Math.max(maxValue[i - 1], value);
            if (value > 0) {
                sum = sum + value;
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] test1 = {7, 1, 5, 3, 6, 4};
        int[] test2 = {1, 2, 3, 4, 5};
        int[] test3 = {7, 6, 4, 3, 1};
        Solution122 solution122 = new Solution122();
        System.out.println(solution122.maxProfit(test1));
        System.out.println(solution122.maxProfit(test2));
        System.out.println(solution122.maxProfit(test3));
    }
}
