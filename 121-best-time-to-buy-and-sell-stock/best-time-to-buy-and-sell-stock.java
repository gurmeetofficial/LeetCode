class Solution {
    public int maxProfit(int[] prices) {
        int curStock = prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++) {
            if(prices[i]<curStock) {
                curStock = prices[i];
            } else {
                profit = Math.max(profit, prices[i]-curStock);
            }
        }
        return profit;
    }
}