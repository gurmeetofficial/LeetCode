class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows=obstacleGrid.length;
        int cols=obstacleGrid[0].length;
        int dp[][]=new int[rows][cols];
        for(int i=0;i<rows;i++) {
            if(obstacleGrid[i][0]==0) dp[i][0]=1;
            else break;
        }
        for(int i=0;i<cols;i++) {
            if(obstacleGrid[0][i]==0) dp[0][i]=1;
            else break;
        }
        for(int i=1;i<rows;i++) {
            for(int j=1;j<cols;j++) {
                if(obstacleGrid[i][j]==0) {
                    if(obstacleGrid[i-1][j]==0) {
                        dp[i][j]=dp[i-1][j];
                    }
                    if(obstacleGrid[i][j-1]==0) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}