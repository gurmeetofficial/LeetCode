class Solution {
    int[][][] dp;
    public int maxProfitRec(int[] prices, int curIndex, int canBuy, int transactionsLeft) {
        if (transactionsLeft<1 || curIndex>=prices.length) {
            return 0;
        }

        if (dp[curIndex][canBuy][transactionsLeft]>-1) {
            return dp[curIndex][canBuy][transactionsLeft];
        }
        int profit = 0;
        if(canBuy == 1) {
            int buyProfit = -prices[curIndex]+maxProfitRec(prices, curIndex+1, 0,  transactionsLeft);
            int skipProfit = maxProfitRec(prices, curIndex+1, 1,  transactionsLeft);
            profit = Math.max(buyProfit, skipProfit);
        } else {
            int sellProfit = prices[curIndex]+maxProfitRec(prices, curIndex+1, 1,  transactionsLeft-1);
            int skipProfit = maxProfitRec(prices, curIndex+1, 0,  transactionsLeft);
            profit = Math.max(sellProfit, skipProfit);
        }
        dp[curIndex][canBuy][transactionsLeft] = profit;
        return profit;
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        dp = new int[len][2][3];
        for(int i=0;i<len;i++) {
            for(int j=0;j<2;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfitRec(prices, 0, 1, 2);
    }
}