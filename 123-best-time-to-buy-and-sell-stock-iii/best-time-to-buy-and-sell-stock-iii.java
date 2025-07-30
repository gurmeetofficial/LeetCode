class Solution {
    // dp[index][canBuy][transactionsLeft]
    private int[][][] dp;

    private int maxProfitRec(int[] prices, int index, int canBuy, int transactionsLeft) {
        if (index >= prices.length || transactionsLeft == 0) {
            return 0;
        }

        // If we've already computed this state, return the stored result
        if (dp[index][canBuy][transactionsLeft] != -1) {
            return dp[index][canBuy][transactionsLeft];
        }

        int result;
        if (canBuy == 1) { // If we can buy
            int buyProfit = -prices[index] + maxProfitRec(prices, index + 1, 0, transactionsLeft);
            int skipProfit = maxProfitRec(prices, index + 1, 1, transactionsLeft);
            result = Math.max(buyProfit, skipProfit);
        } else { // If we must sell
            int sellProfit = prices[index] + maxProfitRec(prices, index + 1, 1, transactionsLeft - 1);
            int skipProfit = maxProfitRec(prices, index + 1, 0, transactionsLeft);
            result = Math.max(sellProfit, skipProfit);
        }

        // Store the result before returning
        dp[index][canBuy][transactionsLeft] = result;
        return result;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // Initialize DP table with -1 (uncomputed)
        dp = new int[n][2][3]; // index, canBuy (0/1), transactionsLeft (0/1/2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfitRec(prices, 0, 1, 2);
    }
}