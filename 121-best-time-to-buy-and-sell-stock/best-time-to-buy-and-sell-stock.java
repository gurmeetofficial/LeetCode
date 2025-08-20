class Solution {
    public int maxProfit(int[] prices) {
        int curPrice = prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i]<=curPrice) curPrice = prices[i];
            else profit=Math.max(profit, prices[i]-curPrice);
        }
        return profit;
    }
}