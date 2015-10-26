/*************************************************************************
    > File Name: 121_BuyAndSellStock.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    > Created Time: 一 10/26 10:33:10 2015
 ************************************************************************/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int low = prices[0];
        int result = 0;
        
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] < low) {
                low = prices[i];
            } else if (prices[i] - low > result){
                result = prices[i] - low;
            }
        }
        
        return result;
    }
}
