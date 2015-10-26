/*************************************************************************
    > File Name: 122_BuyAndSellStockII.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    > Created Time: 一 10/26 10:40:56 2015
 ************************************************************************/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int result = 0;
        
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        
        return result;
    }
}
